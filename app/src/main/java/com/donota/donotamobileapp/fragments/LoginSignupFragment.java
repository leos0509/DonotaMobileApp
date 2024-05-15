package com.donota.donotamobileapp.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.FragmentLoginSignupBinding;

public class LoginSignupFragment extends Fragment {

    FragmentLoginSignupBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showInitialFragment();

        Button btnSignUp = binding.btnSignUp;
        Button btnLogIn = binding.btnLogIn;

        btnLogIn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary2)));
        btnSignUp.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.secondary2)));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSignUp.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary2)));
                btnLogIn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.secondary2)));

                navigateToRegister();
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogIn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary2)));
                btnSignUp.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.secondary2)));

                navigateToLogIn();
            }
        });
    }

    private void showInitialFragment() {
        FragmentManager manager = getChildFragmentManager();
        if (manager.findFragmentById(R.id.containerLogInLayout) == null) {
            navigateToLogIn();
        }
    }

    private void navigateToRegister() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerLogInLayout, new RegisterFragment(), "Register");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToLogIn() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerLogInLayout, new LogInFragment(), "Log In");
        transaction.addToBackStack(null);
        transaction.commit();
    }

}