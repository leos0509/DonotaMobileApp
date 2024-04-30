package com.donota.donotamobileapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.FragmentPasswordConfirmationBinding;

public class PasswordConfirmationFragment extends Fragment {
    private FragmentPasswordConfirmationBinding binding;

    public PasswordConfirmationFragment() {
    }

    public static PasswordConfirmationFragment newInstance() {
        return new PasswordConfirmationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPasswordConfirmationBinding.inflate(inflater, container, false);

        binding.btnConfirmOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.add(R.id.rootNavFragmentContainer, new ResetPwFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        loadTopMenu();

        return binding.getRoot();
    }

    private void loadTopMenu() {
        TopMenuFragment topMenuFragment = new TopMenuFragment();
        Bundle args = new Bundle();
        args.putString("title", "Xác nhận OTP");
        topMenuFragment.setArguments(args);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.topMenuFragment, topMenuFragment);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
