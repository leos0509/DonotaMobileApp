package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.ProductCarouselAdapter;
import com.donota.donotamobileapp.database.impl.TbCartImpl;
import com.donota.donotamobileapp.database.impl.TbProductImpl;
import com.donota.donotamobileapp.databinding.FragmentProductDetailBinding;
import com.donota.donotamobileapp.model.Product;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.CarouselItemDecoration;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailFragment extends Fragment {

    private List<ProductCard> productCards;

    TbProductImpl tbProduct;

    RecyclerView recyclerView;

    OnSelectedSimilarProduct similarProductPasser;

    FragmentProductDetailBinding binding;
    Product product;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false);

        
        product = getData();
        setUpProduct(product);
        loadTopMenu();
        addEvents(product);

        return binding.getRoot();
    }

    private void addEvents(Product product) {
        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getProductData(product);
                if (getActivity() instanceof OnProductBuyListener) {
                    ((OnProductBuyListener) getActivity()).onBuyProductSelected(bundle);
                }
            }
        });
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int customerId = PreferenceUtils.getCustomerId(getContext());
                String productId = product.getProductId();
                TbCartImpl tbCart = new TbCartImpl(getContext());

                String sqlUpdateCart = "UPDATE tbcustomercart\n" +
                                    "   SET quantity = CASE\n" +
                                    "                 WHEN customerid = " + customerId +"  AND productid LIKE '" +productId + "'\n" +
                                    "                 THEN quantity + 1\n" +
                                    "                 ELSE quantity\n" +
                                    "               END\n" +
                                    "WHERE customerid = 'customerid' AND productid = 'productid';";
                boolean checkExist = false;

                String sqlQuerycheck = "SELECT * FROM tbcustomercart WHERE customerid = " +customerId+ " AND productid =  '" + productId + "'";
                Cursor cursor = tbCart.queryData(sqlQuerycheck);
                if (cursor != null && cursor.getCount() != 0) {
                    checkExist = true;
                }
                if (checkExist) {
                    boolean updateFlag = tbCart.execSql(sqlUpdateCart);
                } else {
                    boolean insertFlag = tbCart.insertData(customerId,productId);
                }
                cursor.close();
                tbCart.close();
                Toast.makeText(getContext(), "Sản phẩm đã thêm vào giỏ thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Bundle getProductData(Product product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("checkOutProduct", product);
        return bundle;
    }

    private void setUpSimilarProduct(Product product) {
        ProductCarouselAdapter adapter = new ProductCarouselAdapter(getContext(), getSimilarProduct(product), productCard -> {
            sendSimilarProduct(productCard.getProductId());
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_4dp);
        recyclerView.addItemDecoration(new CarouselItemDecoration(spacingInPixels, spacingInPixels));
    }

    private Product getData() {
        Bundle bundle = getArguments();
        String productId = "*";
        if (bundle != null) {
            productId = bundle.getString("selectedProductId");
        }
        Product product = new Product();
        tbProduct = new TbProductImpl(getContext());
        String sql = "SELECT productid,\n" +
                "       productname,\n" +
                "       productprice,\n" +
                "       productcategory,\n" +
                "       productcategorysub1,\n" +
                "       productcategorysub2,\n" +
                "       productcategorysub3,\n" +
                "       productcategorysub4,\n" +
                "       productdescription,\n" +
                "       productimg,\n" +
                "       productrating\n" +
                "  FROM tbproduct \n" +
                "WHERE productid LIKE '" + productId + "';";
        Cursor cursor = tbProduct.queryData(sql);
        if (cursor.moveToFirst()) {
            String[] imgUrls = cursor.getString(9).split(";");
            String itemImg = imgUrls[0].trim();
            String productColection = !cursor.getString(7).equals("1") ? cursor.getString(7) : "";
            product.setProductId(productId);
            product.setProductName(cursor.getString(1));
            product.setProductPrice(cursor.getInt(2));
            product.setProductCategory(cursor.getString(3));
            product.setProductCategorySub1(cursor.getString(4));
            product.setProductCategorySub2(cursor.getString(5));
            product.setProductCategorySub3(cursor.getString(6));
            product.setProductCategorySub4(productColection);
            product.setProductDescription(cursor.getString(8));
            product.setProductImg(itemImg);
            product.setProductRating(cursor.getString(10));
        }
        cursor.close();
        tbProduct.close();
        return product;
    }
    private void setUpProduct(Product product) {
        binding.txtProductName.setText(product.getProductName());
        binding.txtProductPrice.setText(String.valueOf(product.getProductPrice()));
        binding.txtDescriptionContent.setText(product.getProductDescription());
        binding.txtRating.setText(product.getProductRating());
        Glide.with(getContext())
                .load(product.getProductImg())
                .into(binding.imvProductThumb);
    }

    private List<ProductCard> getSimilarProduct(Product product) {
        String cate1 = product.getProductCategorySub1();
        String cate2 = product.getProductCategorySub2();
        String cate3 = product.getProductCategorySub3();
        String cate4 = product.getProductCategorySub4();
        String productId = product.getProductId();

        List<ProductCard> productList = new ArrayList<>();
        String queryProduct = "SELECT productimg, productname, productrating, productprice, productId FROM tbproduct " +
                                "WHERE (productid NOT LIKE '" + productId + "') AND (productcategorysub1 LIKE '"+ cate1 + "' OR productcategorysub2 LIKE '"+
                                cate2 +"' OR productcategorysub3 LIKE '" + cate3 + "' OR productcategorysub4 LIKE '"+ cate4 + "');";
        Cursor cursor = tbProduct.queryData(queryProduct);
        while (cursor!= null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(0).split(";");
            String firstImg = imgUrls[0].trim();
            productList.add(new ProductCard(firstImg, cursor.getString(1),cursor.getString(2),cursor.getInt(3), cursor.getString(4)));
        }
        cursor.close();
        tbProduct.close();
        return productList;
    }

    private void loadTopMenu() {
        TopMenuFragment topMenuFragment = new TopMenuFragment();
        Bundle args = new Bundle();
        args.putString("title", "Chi tiết sản phẩm");
        topMenuFragment.setArguments(args);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.topMenuFragment, topMenuFragment);
        transaction.commit();
    }

    public interface OnProductBuyListener {
        void onBuyProductSelected(Bundle bundle);
    }

    public interface OnSelectedSimilarProduct {
        void onSimilarProduct(String selectedProductID);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HomePageFragment.OnDataPass) {
            similarProductPasser = (OnSelectedSimilarProduct) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnDataPass interface");
        }
    }
    public void sendSimilarProduct (String productId) {
        similarProductPasser.onSimilarProduct(productId);
    }

}
