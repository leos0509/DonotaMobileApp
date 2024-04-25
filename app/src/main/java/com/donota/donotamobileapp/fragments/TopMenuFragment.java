package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.donota.donotamobileapp.R;

public class TopMenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.backButton).setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.popBackStack();
        });

        Bundle args = getArguments();
        String title = null;
        if (args != null) {
            title = args.getString("title");
        }

        if (title != null) {
            Log.d("TopMenuFragment", "Title retrieved: " + title);
            TextView titleTextView = view.findViewById(R.id.titleTextView);
            titleTextView.setText(title);
        } else {
            Log.d("TopMenuFragment", "Title is null");
        }
    }
}
