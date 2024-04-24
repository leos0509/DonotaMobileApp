package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.donota.donotamobileapp.R;

public class TopMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the back button
        view.findViewById(R.id.backButton).setOnClickListener(v -> {
            NavHostFragment.findNavController(TopMenuFragment.this).navigateUp();
        });

        // Safely retrieve the title from arguments
        Bundle args = getArguments();
        String title = null;
        if (args != null) {
            title = args.getString("title");
        }

        // Check if title is not null before setting it
        if (title != null) {
            TextView titleTextView = view.findViewById(R.id.titleTextView);
            titleTextView.setText(title);
        } else {
        }
    }
}
