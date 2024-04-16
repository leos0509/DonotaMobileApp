package com.donota.donotamobileapp;

import android.app.Dialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.donota.adapters.SettingOptionsAdapter;
import com.donota.donotamobileapp.databinding.ActivityAccountBinding;
import com.donota.models.SettingOptions;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {

    ActivityAccountBinding binding;
    Dialog dialog;

    SettingOptionsAdapter settingOptionsAdapter;
    ArrayList<SettingOptions> settingOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void initData() {
        settingOptions = new ArrayList<>();
        settingOptions.add(new SettingOptions("personal_info", R.drawable.baseline_person, "Tai khoan"));
        settingOptions.add(new SettingOptions("setting", R.drawable.baseline_settings, "Cai dat chung"));
        settingOptions.add(new SettingOptions("payment_setting", R.drawable.baseline_credit_card, "Cai dat thanh toan"));
        settingOptions.add(new SettingOptions("address_setting", R.drawable.baseline_location, "Cai dat dia chi"));
        settingOptions.add(new SettingOptions("policy_setting", R.drawable.baseline_policy, "Chinh sach"));
    }

    private void loadData() {
        initData();
        settingOptionsAdapter = new SettingOptionsAdapter(AccountActivity.this, R.layout.setting_items_layout, settingOptions);
        binding.lvSettingOptions.setAdapter(settingOptionsAdapter);
    }
}