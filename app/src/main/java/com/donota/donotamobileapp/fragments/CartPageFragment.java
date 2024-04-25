package com.donota.donotamobileapp.fragments;

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
import com.donota.donotamobileapp.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartPageFragment extends Fragment implements CartItemAdapter.OnCheckedItemCountChangedListener {

    public CartPageFragment() {}

    public static CartPageFragment newInstance() {
        CartPageFragment fragment = new CartPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_page, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recvCartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Item 1", 19.99, 1));
        cartItems.add(new CartItem("Item 2", 29.99, 2));

        CartItemAdapter adapter = new CartItemAdapter(cartItems, this);
        recyclerView.setAdapter(adapter);

        loadTopMenu();

        return view;
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