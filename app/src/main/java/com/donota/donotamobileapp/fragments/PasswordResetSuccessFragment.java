package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.FragmentPasswordResetSuccessBinding;

public class PasswordResetSuccessFragment extends Fragment {

    private FragmentPasswordResetSuccessBinding binding;

    public PasswordResetSuccessFragment() {
        // Required empty public constructor
    }

    public static PasswordResetSuccessFragment newInstance() {
        return new PasswordResetSuccessFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPasswordResetSuccessBinding.inflate(inflater, container, false);

        binding.btnViewLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.rootNavFragmentContainer, new LoginSignupFragment());
                transaction.commit();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
