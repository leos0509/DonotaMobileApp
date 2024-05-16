package com.donota.donotamobileapp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentProfileBinding;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        setupData();
        addEvent();
        return binding.getRoot();

    }

    private void setupData() {
        int customerId = PreferenceUtils.getCustomerId(getContext());
        String customerName = "";
        String customerAccount = "";
        int dob = 0;
        String phoneNumb = "";
        String email = "";

        String query = "SELECT customername,\n" +
                "       phonenumb,\n" +
                "       customeraccount,\n" +
                "       customerdob,\n" +
                "       customeremail\n" +
                "  FROM tbcustomerprofile WHERE customerid = " + customerId + ";";
        TbCustomerProfileImpl tbCustomerProfile = new TbCustomerProfileImpl(getContext());
        Cursor cursor = tbCustomerProfile.queryData(query);
        while (cursor.moveToNext()) {
            customerName = cursor.getString(0);
            customerAccount = cursor.getString(2);
            dob = cursor.getInt(3);
            phoneNumb = cursor.getString(1);
            email = cursor.getString(4);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        Date dateDob = new Date(dob);
        String dateString = formatter.format(dateDob);

        binding.txtNameValue.setText(customerName);
        binding.txtUserName.setText(customerAccount);
        if (dob != 0) {
            binding.txtBirthdayValue.setText(dateString);
        } else {
            binding.txtBirthdayValue.setText("");
        }

        binding.txtUserEmail.setText(email);
        binding.txtPhoneValue.setText(phoneNumb);
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
