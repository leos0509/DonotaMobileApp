package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.BestSellerCarouselAdapter;
import com.donota.donotamobileapp.adapter.CategoryCarouselAdapter;
import com.donota.donotamobileapp.adapter.ProductGridAdapter;
import com.donota.donotamobileapp.model.CarouselItem;
import com.donota.donotamobileapp.model.ProductCard;
import com.donota.donotamobileapp.utils.CarouselItemDecoration;
import com.donota.donotamobileapp.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageFragment extends Fragment implements ProductGridAdapter.OnProductClickListener {

    private RecyclerView carouselRecyclerView1;
    private RecyclerView carouselRecyclerView2;
    private BestSellerCarouselAdapter carouselAdapter1;
    private CategoryCarouselAdapter carouselAdapter2;

    private RecyclerView recyclerView; // This should be initialized before use
    private ProductGridAdapter productAdapter;
    private List<ProductCard> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        carouselRecyclerView1 = view.findViewById(R.id.revCarouselBestSeller);
        carouselRecyclerView2 = view.findViewById(R.id.revCarouselCategory);
        recyclerView = view.findViewById(R.id.revProduct);
        setupCarousels();
        setupProducts();

        loadFragment();

        ImageView imageView = view.findViewById(R.id.imvSlider);

        String imageUrl = "https://mocshop.com.vn/library/module_new/bao-gia-thiet-ke---thi-cong-noi-that_s2030.jpg";
        Glide.with(getContext()) // Use getContext() instead of this
                .load(imageUrl)
                .override(200, 100)
                .centerCrop()
                .into(imageView);

        return view;
    }

    private void setupProducts() {
        ArrayList<ProductCard> productCards = new ArrayList<>();
        productCards.add(new ProductCard(R.drawable.dining_table, "Product Name 1", "5.0", "190.000đ"));
        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));
        productCards.add(new ProductCard(R.drawable.sofa, "Product Name 2", "5.0", "250.000đ"));

        ProductGridAdapter productGridAdapter = new ProductGridAdapter(getContext(), productCards, this);
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

    private void setupCarousels() {
        List<CarouselItem> items = Arrays.asList(
                new CarouselItem(R.drawable.bed),
                new CarouselItem(R.drawable.sofa),
                new CarouselItem(R.drawable.dining_table),
                new CarouselItem(R.drawable.chair),
                new CarouselItem(R.drawable.storage),
                new CarouselItem(R.drawable.tv_board),
                new CarouselItem(R.drawable.living_table)
        );

        // Setup for the first carousel
        carouselRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        carouselAdapter1 = new BestSellerCarouselAdapter(getContext(), items, new BestSellerCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        carouselRecyclerView1.setAdapter(carouselAdapter1);

        carouselRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        carouselAdapter2 = new CategoryCarouselAdapter(getContext(), items, new CategoryCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        carouselRecyclerView2.setAdapter(carouselAdapter2);


        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_2dp);
        carouselRecyclerView1.addItemDecoration(new CarouselItemDecoration(spacingInPixels, spacingInPixels));
        carouselRecyclerView2.addItemDecoration(new CarouselItemDecoration(spacingInPixels, spacingInPixels));
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.navigation_bar, new NavigationBarFragment());
        transaction.commit();
    }
}
