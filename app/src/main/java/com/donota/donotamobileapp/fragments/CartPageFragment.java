package com.donota.donotamobileapp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.CartItemAdapter;
import com.donota.donotamobileapp.database.impl.TbCartImpl;
import com.donota.donotamobileapp.model.CartItem;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPageFragment extends Fragment implements CartItemAdapter.OnCheckedItemCountChangedListener {

    RecyclerView recyclerView;

    public CartPageFragment() {}

    public static CartPageFragment newInstance() {
        CartPageFragment fragment = new CartPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_page, container, false);

        recyclerView = view.findViewById(R.id.recvCartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadTopMenu();
        initAdapter();

        return view;
    }

    private List<CartItem> loadData (){
        int customerid = PreferenceUtils.getCustomerId(getContext());
        List<CartItem> cartItems = new ArrayList<>();
        TbCartImpl tbCart = new TbCartImpl(getContext());
        String sql = "SELECT tbc.customerid,\n" +
                "       tbc.productid,\n" +
                "       tbc.quantity, \n" +
                "       tbp.productprice,\n" +
                "       tbp.productname,\n" +
                "       tbp.productimg\n" +
                "FROM tbcustomercart tbc\n" +
                "JOIN tbproduct tbp\n" +
                "ON tbc.productid = tbp.productid\n" +
                "WHERE tbc.customerid = " + customerid + ";";
        Cursor cursor = tbCart.queryData(sql);

        while (cursor != null && cursor.moveToNext()) {
            String[] imgUrls = cursor.getString(5).split(";");
            String itemImg = imgUrls[0].trim();
            cartItems.add(new CartItem(itemImg,cursor.getString(4), cursor.getInt(3), cursor.getInt(2)));
        }
        cursor.close();
        tbCart.close();

        return cartItems;
    }
    private void initAdapter() {
        List<CartItem> cartItems = loadData();
        CartItemAdapter adapter = new CartItemAdapter(getContext(),cartItems, this);
        recyclerView.setAdapter(adapter);
    }


    private void loadTopMenu() {
        TopMenuFragment topMenuFragment = new TopMenuFragment();
        Bundle args = new Bundle();
        args.putString("title", "Giỏ hàng");
        topMenuFragment.setArguments(args);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.topMenuFragment, topMenuFragment);
        transaction.commit();
    }

    @Override
    public void onCheckedItemCountChanged(int count) {}

    @Override
    public void onCheckedItemPriceSumChanged(double sum) {
        TextView checkedItemPriceSumTextView = getView().findViewById(R.id.txtTotalPrice);
        checkedItemPriceSumTextView.setText(String.valueOf(sum));
    }
}