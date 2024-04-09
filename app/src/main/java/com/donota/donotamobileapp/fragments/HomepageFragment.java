package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.CarouselAdapter;
import com.donota.donotamobileapp.model.CarouselItem;

import java.util.Arrays;
import java.util.List;

public class HomepageFragment extends Fragment {

    private RecyclerView carouselRecyclerView;
    private CarouselAdapter carouselAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        carouselRecyclerView = view.findViewById(R.id.carousel_recycler_view);
        carouselRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupCarousel();
    }

    private void setupCarousel() {
        List<CarouselItem> items = Arrays.asList(
                new CarouselItem(R.drawable.bed),
                new CarouselItem(R.drawable.sofa),
                new CarouselItem(R.drawable.dining_table),
                new CarouselItem(R.drawable.chair),
                new CarouselItem(R.drawable.storage),
                new CarouselItem(R.drawable.tv_board),
                new CarouselItem(R.drawable.living_table)
        );
        carouselAdapter = new CarouselAdapter(getContext(), items, new CarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        carouselRecyclerView.setAdapter(carouselAdapter);
    }
}
