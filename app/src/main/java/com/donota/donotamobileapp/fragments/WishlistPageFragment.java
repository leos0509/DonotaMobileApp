package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.ProductGridAdapter;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class WishlistPageFragment extends Fragment implements ProductGridAdapter.OnProductClickListener {

    private RecyclerView recyclerView;
    private ProductGridAdapter productAdapter;
    private List<ProductCard> productList;

    public WishlistPageFragment() {
    }

    public static WishlistPageFragment newInstance(String param1, String param2) {
        WishlistPageFragment fragment = new WishlistPageFragment();
        // You can pass parameters to the fragment here if needed
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist_page, container, false);
        setupProducts(view);
        return view;
    }

    private void setupProducts(View view) {
        recyclerView = view.findViewById(R.id.revWishlistProduct);
        ArrayList<ProductCard> productCards = new ArrayList<>();
//        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
//        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
//        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
//        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
//        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
//        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
//        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
//        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
//        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
//        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));

        ProductGridAdapter productGridAdapter = new ProductGridAdapter(getContext(), productCards, (ProductGridAdapter.OnProductClickListener) this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(productGridAdapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_4dp);
        recyclerView.addItemDecoration(new SpacingItemDecoration(spacingInPixels, spacingInPixels));
    }

    @Override
    public void onProductClick(ProductCard productCard) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.rootNavFragmentContainer, new ProductDetailFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}