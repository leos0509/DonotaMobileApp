package com.donota.donotamobileapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityMainBinding;
import com.donota.donotamobileapp.fragments.HomeNavFragment;

public class MainActivity extends AppCompatActivity{
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragmentManager.findFragmentById(R.id.rootNavFragmentContainer) == null) {
            transaction.add(R.id.rootNavFragmentContainer, new HomeNavFragment());
        }
        transaction.commit();
    }
}