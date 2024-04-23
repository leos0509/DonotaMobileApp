package com.donota.donotamobileapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.donota.donotamobileapp.databinding.ActivityChangePwSuccessBinding;

public class ChangePwSuccessActivity extends AppCompatActivity {

    ActivityChangePwSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePwSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnViewLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePwSuccessActivity.this, LoginSignupActivity.class);
                startActivity(intent);
            }
        });
    }
}