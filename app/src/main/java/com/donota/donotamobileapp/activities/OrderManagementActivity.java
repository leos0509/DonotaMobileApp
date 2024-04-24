package com.donota.donotamobileapp.activities;

import android.app.Dialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.ProductOrderAdapter;
import com.donota.donotamobileapp.databinding.ActivityOrderManagementBinding;
import com.donota.donotamobileapp.fragments.AddressSettingsFragment;
import com.donota.donotamobileapp.fragments.ConfirmedOrderFragment;
import com.donota.donotamobileapp.fragments.PaymentSettingsFragment;
import com.donota.donotamobileapp.fragments.PolicyFragment;
import com.donota.donotamobileapp.fragments.ProfileFragment;
import com.donota.donotamobileapp.models.ProductOrder;
import com.donota.donotamobileapp.models.SettingOptions;

import java.util.ArrayList;

public class OrderManagementActivity extends AppCompatActivity {

    ActivityOrderManagementBinding binding;
    Dialog dialog;

    ProductOrderAdapter productOrderAdapter;
    ArrayList<ProductOrder> productOrders;
    ConfirmedOrderFragment confirmedOrderFragment = new ConfirmedOrderFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderManagementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.fcvOrderManagement,confirmedOrderFragment).commit();

        loadFragment();
    }

    private void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ConfirmedOrderFragment confirmedOrderFragment = new ConfirmedOrderFragment();
        transaction.replace(R.id.fcvOrderManagement, confirmedOrderFragment);
        transaction.commit();
    }

    private void loadConfirmedOrderFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ConfirmedOrderFragment confirmedOrderFragment = new ConfirmedOrderFragment();
        transaction.replace(R.id.fcvOrderManagement, confirmedOrderFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}