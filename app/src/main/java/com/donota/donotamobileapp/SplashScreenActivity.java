package com.donota.donotamobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.donota.adapters.ViewPagerAdapter;
import com.donota.donotamobileapp.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    Button btn_next, btn_skip;
    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;
    ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        btn_next = binding.btnNext;
        btn_skip = binding.btnSkip;

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) < 1)
                    mSlideViewPager.setCurrentItem(getItem(1), true);
                else {
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        mSlideViewPager = binding.slideViewPager;
        mDotLayout = binding.indicatorLayout;
        viewPagerAdapter = new ViewPagerAdapter(this);
        mSlideViewPager.setAdapter(viewPagerAdapter);
        setUpIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void setUpIndicator(int position) {
        dots = new TextView[2];
        mDotLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.secondary1, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.primary1, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i) {
        return mSlideViewPager.getCurrentItem() + i;
    }
}