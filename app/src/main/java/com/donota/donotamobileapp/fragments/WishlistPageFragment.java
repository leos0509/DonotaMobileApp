package com.donota.donotamobileapp.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.ProductGridAdapter;
import com.donota.donotamobileapp.database.impl.TbCustomerWishListImpl;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.PreferenceUtils;
import com.donota.donotamobileapp.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class WishlistPageFragment extends Fragment implements ProductGridAdapter.OnProductClickListener, ProductGridAdapter.OnProductLongClickListener {

    private RecyclerView recyclerView;
    private ProductGridAdapter productAdapter;
    private List<ProductCard> productCards;

    private ProductCard productCard;

    private View view;

    private TbCustomerWishListImpl tbCustomerWishList;

    public WishlistPageFragment() {
    }

    public static WishlistPageFragment newInstance() {
        WishlistPageFragment fragment = new WishlistPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wishlist_page, container, false);
        setupProducts(view);
        loadTopMenu();

        return view;
    }

    private void setupProducts(View view) {
        recyclerView = view.findViewById(R.id.revWishlistProduct);
        productCards = loadWishListData();

        productAdapter = new ProductGridAdapter(getContext(), productCards,this, this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(productAdapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_4dp);
        recyclerView.addItemDecoration(new SpacingItemDecoration(spacingInPixels, spacingInPixels));
    }

    private List<ProductCard> loadWishListData() {
        List<ProductCard> productList = new ArrayList<>();
        tbCustomerWishList = new TbCustomerWishListImpl(getContext());
        int customerId = PreferenceUtils.getCustomerId(getContext());
        String queryProduct = "SELECT productimg, productname, productrating, productprice, tp.productid \n" +
                "FROM tbproduct tp \n" +
                "JOIN tbcustomerwishlist tw \n" +
                "ON tp.productid = tw.productid \n" +
                "WHERE tw.customerid = " + customerId;
        Cursor cursor = tbCustomerWishList.queryData(queryProduct);
        while (cursor != null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(0).split(";");
            String firstImg = imgUrls[0].trim();
            productList.add(new ProductCard(firstImg, cursor.getString(1),cursor.getString(2),cursor.getInt(3), cursor.getString(4)));
        }
        cursor.close();
        tbCustomerWishList.close();
        return productList;
    }

    private void loadTopMenu() {
        TopMenuFragment topMenuFragment = new TopMenuFragment();
        Bundle args = new Bundle();
        args.putString("title", "Sản phẩm yêu thích");
        topMenuFragment.setArguments(args);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.topMenuFragment, topMenuFragment);
        transaction.commit();
    }

    @Override
    public void onProductClick(ProductCard productCard) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.rootNavFragmentContainer, new ProductDetailFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onProductLongClick(ProductCard productCard) {
        int customerId = PreferenceUtils.getCustomerId(getContext());
        String productId = productCard.getProductId();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Bạn có muốn xóa sản phẩm \"" + productCard.getProductName() + "\" khỏi wishlist ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tbcustomerwishlist\n" +
                        "      WHERE customerid = '"+ customerId +"' AND \n" +
                        "            productid = '"+ productId +"';";
                Log.d("Delete notification","Da xoa");
                tbCustomerWishList = new TbCustomerWishListImpl(getContext());
                boolean deletedRows = tbCustomerWishList.execSql(sql);
                if (deletedRows) {
                    Toast.makeText(getContext(),"Delete success",Toast.LENGTH_SHORT).show();
                    productAdapter.clear();
                    setupProducts(view);
                } else {
                    Toast.makeText(getContext(),"Delete fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
        return false;
    }
}