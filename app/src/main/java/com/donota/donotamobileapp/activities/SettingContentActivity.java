package com.donota.donotamobileapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.fragments.AddressSettingsFragment;
import com.donota.donotamobileapp.fragments.PaymentSettingsFragment;
import com.donota.donotamobileapp.fragments.PolicyFragment;
import com.donota.donotamobileapp.fragments.ProfileFragment;
import com.donota.donotamobileapp.R;
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
        } else if ("wishlist".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new AddressSettingsFragment());
        }else if ("payment_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new PaymentSettingsFragment());
        } else if ("address_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new AddressSettingsFragment());
        } else if ("policy_setting".equals(settingID)) {
            transaction.replace(R.id.fcvSetting, new PolicyFragment());
        }

        transaction.commit();
    }
}