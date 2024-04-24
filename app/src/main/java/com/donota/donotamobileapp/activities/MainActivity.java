package com.donota.donotamobileapp.activities;

import static com.donota.donotamobileapp.utils.DbUtils.DB_FOLDER;
import static com.donota.donotamobileapp.utils.DbUtils.DB_NAME;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityMainBinding;
import com.donota.donotamobileapp.fragments.AccountPageFragment;
import com.donota.donotamobileapp.fragments.HomeNavFragment;
import com.donota.donotamobileapp.fragments.HomePageFragment;
import com.donota.donotamobileapp.fragments.LogInFragment;
import com.donota.donotamobileapp.fragments.SplashScreenFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements LogInFragment.OnLoginSuccessListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment();
        setUpDatabase();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragmentManager.findFragmentById(R.id.rootNavFragmentContainer) == null) {
            transaction.add(R.id.rootNavFragmentContainer, new HomeNavFragment());
        }
        transaction.commit();
    }

    private void setUpDatabase() {
        File dbFile = getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            try {
                // Create the directory if it doesn't exist
                File dbFolder = new File(getApplicationInfo().dataDir + DB_FOLDER);
                if (!dbFolder.exists()) {
                    dbFolder.mkdir();
                }

                // Copy the database file from assets to the data directory
                InputStream inputStream = getAssets().open(DB_NAME);
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


    @Override
    public void onLoginSuccess() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rootNavFragmentContainer, new HomeNavFragment(), "Login Success");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
