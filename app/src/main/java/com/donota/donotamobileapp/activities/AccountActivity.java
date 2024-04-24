package com.donota.donotamobileapp.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.SettingOptionsAdapter;
import com.donota.donotamobileapp.databinding.ActivityAccountBinding;
import com.donota.donotamobileapp.models.SettingOptions;

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
        addEvents();
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

    private void addEvents() {
        binding.lvSettingOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SettingOptions selectedOption = settingOptions.get(position);
                Intent intent = new Intent(AccountActivity.this, SettingContentActivity.class);
                intent.putExtra("settingID", selectedOption.getSettingID());
                startActivity(intent);
            }
        });
    }
}