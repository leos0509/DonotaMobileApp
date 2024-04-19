package com.donota.donotamobileapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.databinding.ActivitySettingContentBinding;

public class SettingContentActivity extends AppCompatActivity {

    ActivitySettingContentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment();
    }

    private void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        String settingID = getIntent().getStringExtra("settingID");
        if ("personal_info".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new ProfileFragment());
        } else if ("payment_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new PaymentSettingsFragment());
        } else if ("address_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new AddressSettingsFragment());
        } else if ("policy_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new PolicyFragment());
        }




        transaction.commit();
    }
}