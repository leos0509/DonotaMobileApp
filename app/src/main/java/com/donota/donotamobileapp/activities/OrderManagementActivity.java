package com.donota.donotamobileapp.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
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

    ConfirmedOrderFragment confirmedOrderFragment = new ConfirmedOrderFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderManagementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.fcvOrderManagement,confirmedOrderFragment).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.fcvOrderManagement,confirmedOrderFragment).commit();

        loadFragment();
    }

    private void loadFragment() {
        binding.txtConfirmation.setOnClickListener(clickListener);
        binding.txtPacking.setOnClickListener(clickListener);
        binding.txtDelivery.setOnClickListener(clickListener);
        binding.txtRating.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = null;

            if (view.equals(binding.txtConfirmation)) {
                fragment = new ConfirmedOrderFragment();
                transaction.replace(R.id.fcvOrderManagement, fragment, "Confirmed Order");
                transaction.addToBackStack("FHome");
            } else if (view.equals(binding.txtDelivery)) {
                fragment = new ConfirmedOrderFragment();
                transaction.replace(R.id.fcvOrderManagement, fragment, "Packing Order");
                transaction.addToBackStack("FFavorite");
            } else if (view.equals(binding.txtDelivery)) {
                fragment = new ConfirmedOrderFragment();
                transaction.replace(R.id.fcvOrderManagement, fragment, "Delivering Order");
                transaction.addToBackStack("FCart");
            } else if (view.equals(binding.txtRating)) {
                fragment = new ConfirmedOrderFragment();
                transaction.replace(R.id.fcvOrderManagement, fragment, "Rating");
                transaction.addToBackStack("FProfile");
            }
            transaction.commit();
        }
    };
}