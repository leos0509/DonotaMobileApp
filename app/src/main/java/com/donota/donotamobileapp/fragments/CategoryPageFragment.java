package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapter.CategoryGridAdapter;

public class CategoryPageFragment extends Fragment {

    public CategoryPageFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_page, container, false);

        // Premade item data
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        // Find the RecyclerViews in the inflated layout
        RecyclerView recyclerView1 = view.findViewById(R.id.revCateType);
        RecyclerView recyclerView2 = view.findViewById(R.id.revCateRoom);
        RecyclerView recyclerView3 = view.findViewById(R.id.revCateCollection);

        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView3.setNestedScrollingEnabled(false);

        // Create an instance of CategoryGridAdapter and pass the premade item data
        CategoryGridAdapter adapter = new CategoryGridAdapter(requireContext(), items);

        // Set the adapter to the RecyclerViews
        recyclerView1.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recyclerView1.setAdapter(adapter);

        recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recyclerView2.setAdapter(adapter);

        recyclerView3.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recyclerView3.setAdapter(adapter);

        return view;
    }
}
