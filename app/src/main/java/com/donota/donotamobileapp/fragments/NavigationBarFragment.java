package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.donota.donotamobileapp.R;

public class NavigationBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_bar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize buttons
        Button btnHome = view.findViewById(R.id.btn_home);
        Button btnSearch = view.findViewById(R.id.btn_search);
        Button btnCart = view.findViewById(R.id.btn_cart);
        Button btnProfile = view.findViewById(R.id.btn_profile);

        // Set click listeners for your buttons
        btnHome.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_to_homePageFragment);
        });

        btnSearch.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_to_categoryPageFragment);
        });

        btnCart.setOnClickListener(v -> {
            // Handle cart button click
            // For example, navigate to the cart screen
        });

        btnProfile.setOnClickListener(v -> {
            // Handle profile button click
            // For example, navigate to the profile screen
        });
    }
}
