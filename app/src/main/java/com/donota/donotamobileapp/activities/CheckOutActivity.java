package com.donota.donotamobileapp.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityOrderConfirmationBinding;

public class CheckOutActivity extends AppCompatActivity {
    ActivityOrderConfirmationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityOrderConfirmationBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getData();
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String productId = bundle.getString("productId");
            int productPrice = bundle.getInt("productPrice");
            // Use the data as needed
        }
    }
}