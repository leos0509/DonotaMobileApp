package com.donota.donotamobileapp.fragments;

import static com.donota.donotamobileapp.utils.DbUtils.DB_FOLDER;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.ViewPagerAdapter;
import com.donota.donotamobileapp.databinding.FragmentSplashScreenBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SplashScreenFragment extends Fragment {

    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    Button btn_next, btn_skip;
    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;
    FragmentSplashScreenBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpDatabase();

        btn_next = binding.btnNext;
        btn_skip = binding.btnSkip;

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use FragmentManager to navigate to LoginSignupFragment
                LoginSignupFragment loginSignupFragment = new LoginSignupFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.rootNavFragmentContainer, loginSignupFragment)
                        .commit();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItem(0) < 1)
                    mSlideViewPager.setCurrentItem(getItem(1), true);
                else {
                    // Use FragmentManager to navigate to LoginSignupFragment
                    LoginSignupFragment loginSignupFragment = new LoginSignupFragment();
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.rootNavFragmentContainer, loginSignupFragment)
                            .commit();
                }
            }
        });

        mSlideViewPager = binding.slideViewPager;
        mDotLayout = binding.indicatorLayout;
        viewPagerAdapter = new ViewPagerAdapter(getContext());
        mSlideViewPager.setAdapter(viewPagerAdapter);
        setUpIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    private void setUpDatabase() {
        File dbFile = getActivity().getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            try {
                // Create the directory if it doesn't exist
                File dbFolder = new File(getActivity().getApplicationInfo().dataDir + DB_FOLDER);
                if (!dbFolder.exists()) {
                    dbFolder.mkdir();
                }

                // Copy the database file from assets to the data directory
                InputStream inputStream = getActivity().getAssets().open(DB_NAME);
                OutputStream outputStream = new FileOutputStream(dbFile);
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
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.secondary1, getActivity().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.primary1, getActivity().getTheme()));
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
