package com.donota.donotamobileapp.activities;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.fragments.LogInFragment;
import com.donota.donotamobileapp.fragments.RegisterFragment;
import com.donota.donotamobileapp.databinding.ActivityMainBinding;

import com.donota.donotamobileapp.R;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private AppCompatButton btnLogIn;
    private AppCompatButton btnSignUp;

=======

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityMainBinding;
import com.donota.donotamobileapp.fragments.NavigationBarFragment;

public class MainActivity extends AppCompatActivity{
    ActivityMainBinding binding;

>>>>>>> origin/cart_page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

<<<<<<< HEAD
        addEvents();
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment fragment = null;
            String tag = null;

            if (view.equals(binding.btnSignUp)) {
                fragment = new RegisterFragment();
                tag = "Register";

            } else if (view.equals(binding.btnLogIn)) {
                fragment = new LogInFragment();
                tag = "Log In";
            }

            if (fragment != null && tag != null) {
                transaction.replace(R.id.containerLogInLayout, fragment, tag);
                transaction.addToBackStack(tag);
                transaction.commit();
            }
        }
    };

    private void addEvents() {
        binding.btnSignUp.setOnClickListener(clickListener);
        binding.btnLogIn.setOnClickListener(clickListener);
=======
        loadFragment();
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, new NavigationBarFragment());
        transaction.commit();

>>>>>>> origin/cart_page
    }
}