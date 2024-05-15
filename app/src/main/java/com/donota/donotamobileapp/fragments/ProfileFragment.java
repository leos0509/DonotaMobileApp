package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    public ProfileFragment() {
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadTopMenu() {
        TopMenuFragment topMenuFragment = new TopMenuFragment();
        Bundle args = new Bundle();
        args.putString("title", "Tài khoản");
        topMenuFragment.setArguments(args);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.topMenuFragment, topMenuFragment);
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        loadTopMenu();
        addEvent();
        return binding.getRoot();

    }
    private void addEvent() {
        binding.txtChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.add(R.id.rootNavFragmentContainer, new ResetPwFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


    }

}
