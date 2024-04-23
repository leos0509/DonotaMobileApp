package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.CartItemAdapter;
import com.donota.donotamobileapp.database.impl.TbCartImpl;
import com.donota.donotamobileapp.databinding.FragmentCartPageBinding;
import com.donota.donotamobileapp.model.CartItem;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPageFragment extends Fragment {

    FragmentCartPageBinding binding;
    Context context;
    TbCartImpl tbCart;

    CartItemAdapter adapter;

    List<CartItem> cartItemList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartPageFragment() {
        // Required empty public constructor
    }
    
    public static CartPageFragment newInstance(String param1, String param2) {
        CartPageFragment fragment = new CartPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartPageBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_cart_page, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recvCartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Example data
//        List<CartItem> cartItems = new ArrayList<>();
//        cartItems.add(new CartItem("Item 1", 19.99, 1));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));
//        cartItems.add(new CartItem("Item 2", 29.99, 2));

//        CartItemAdapter adapter = new CartItemAdapter(cartItems);
        loadData();
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

//    private void initData() {
//        = loadData();
//    }

    private List<CartItem> loadData() {
        context = getActivity();
        tbCart = new TbCartImpl(context);
        int customerId = PreferenceUtils.getCustomerId(context);
        cartItemList = new ArrayList<>();
        String queryCart = "SELECT * FROM tbcart WHERE customerid  = " + customerId;
        return cartItemList;
    }

}