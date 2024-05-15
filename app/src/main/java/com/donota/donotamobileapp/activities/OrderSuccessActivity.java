package com.donota.donotamobileapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityOrdersuccessBinding;

public class OrderSuccessActivity extends AppCompatActivity {

    ActivityOrdersuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrdersuccessBinding.inflate(getLayoutInflater());

        Intent intent = new Intent(this, OrderManagementActivity.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        binding.btnViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}