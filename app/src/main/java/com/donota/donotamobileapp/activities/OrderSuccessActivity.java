package com.donota.donotamobileapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityOrdersuccessBinding;
import com.donota.donotamobileapp.fragments.HomePageFragment;
import com.donota.donotamobileapp.fragments.ProductDetailFragment;

public class OrderSuccessActivity extends AppCompatActivity implements HomePageFragment.OnDataPass {

    ActivityOrdersuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrdersuccessBinding.inflate(getLayoutInflater());

        Intent intent = new Intent(this, MainActivity.class);

        HomePageFragment homePageFragment = new HomePageFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        binding.btnViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.rootNavFragmentContainer,homePageFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public void onDataPass(String selectedProductID) {
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("selectedProductId", selectedProductID);
        productDetailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootNavFragmentContainer, productDetailFragment, "Sended selectedProductId")
                .addToBackStack(null)
                .commit();
    }
}