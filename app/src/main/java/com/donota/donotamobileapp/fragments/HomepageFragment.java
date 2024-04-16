package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.BestSellerCarouselAdapter;
import com.donota.donotamobileapp.adapter.CategoryCarouselAdapter;
import com.donota.donotamobileapp.model.CarouselItem;

import java.util.Arrays;
import java.util.List;

public class HomepageFragment extends Fragment {

    private RecyclerView carouselRecyclerView1;
    private RecyclerView carouselRecyclerView2;
    private BestSellerCarouselAdapter carouselAdapter1;
    private CategoryCarouselAdapter carouselAdapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        carouselRecyclerView1 = view.findViewById(R.id.revCarouselBestSeller);
        carouselRecyclerView2 = view.findViewById(R.id.revCarouselCategory);
        setupCarousels();
        return view;
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
                // Handle item click for the first carousel
            }
        });
        carouselRecyclerView1.setAdapter(carouselAdapter1);

        // Setup for the second carousel
        carouselRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        carouselAdapter2 = new CategoryCarouselAdapter(getContext(), items, new CategoryCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click for the second carousel
            }
        });
        carouselRecyclerView2.setAdapter(carouselAdapter2);
    }
}
