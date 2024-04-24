package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        Button btnHome = view.findViewById(R.id.btn_home);
        Button btnSearch = view.findViewById(R.id.btn_search);
        Button btnCart = view.findViewById(R.id.btn_cart);
        Button btnProfile = view.findViewById(R.id.btn_profile);

        btnHome.setOnClickListener(v -> {
            navigateTo(new HomePageFragment());
        });

        btnSearch.setOnClickListener(v -> {
            navigateTo(new WishlistPageFragment());
        });

        btnCart.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.add(R.id.rootNavFragmentContainer, new CartPageFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        btnProfile.setOnClickListener(v -> {
            navigateTo(new AccountPageFragment());
        });
    }
    private void navigateTo(Fragment destinationFragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.homeNavFragmentContainer, destinationFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
