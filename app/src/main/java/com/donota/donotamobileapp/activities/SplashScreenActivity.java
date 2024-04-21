package com.donota.donotamobileapp.activities;

import static com.donota.donotamobileapp.utils.DbUtils.DB_FOLDER;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.ViewPagerAdapter;
import com.donota.donotamobileapp.databinding.ActivitySplashScreenBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

        setUpDatabase();

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


    private void setUpDatabase() {
        File dbFile = getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            String dbPath = getApplicationInfo().dataDir + DB_FOLDER + DB_NAME;
            try {
                InputStream inputStream = getAssets().open(DB_NAME);
                File f = new File(getApplicationInfo().dataDir + DB_FOLDER);
                if (!f.exists()) {
                    f.mkdir();
                }
                OutputStream outputStream = new FileOutputStream(dbPath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("Database", "Database loaded");

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