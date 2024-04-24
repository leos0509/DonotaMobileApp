package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.donota.donotamobileapp.activities.MainActivity;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentLogInBinding;
import com.donota.donotamobileapp.utils.PreferenceUtils;

public class LogInFragment extends Fragment {
    FragmentLogInBinding binding;
    TbCustomerProfileImpl tbCustomerProfile;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public LogInFragment() {
    }

    public static LogInFragment newInstance(String param1, String param2) {
        LogInFragment fragment = new LogInFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLogInBinding.inflate(inflater, container, false);

        binding.btnConfirmLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getActivity();
                String customerAccountEmail = binding.edtUserNameEmail.getText().toString();
                String customerPassword = binding.edtInputPw.getText().toString();
                if (validateCustomerAccountEmail(context, customerAccountEmail)) {
                    if (validatePassword(context, customerPassword, customerAccountEmail)) {
                        tbCustomerProfile = new TbCustomerProfileImpl(context);
                        String queryCustomerId = "SELECT customerid FROM tbcustomerprofile WHERE (customeraccount LIKE '" + customerAccountEmail +
                                "') OR ( customeremail LIKE '" + customerAccountEmail + "')";
                        try {
                            Cursor cursor = tbCustomerProfile.queryData(queryCustomerId);
                            if (cursor != null && cursor.moveToFirst()) {
                                PreferenceUtils.setCustomerId(context, cursor.getString(0));
                                cursor.close();
                                Intent intent = new Intent(context, MainActivity.class);
                                startActivity(intent);
                            }
                        } finally {
                            tbCustomerProfile.close();
                        }

                    } else {
                        Toast.makeText(context, "Mật khẩu sai, xin hãy nhập lại !!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Sai tên đăng nhập hoặc Email, xin hãy nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    private boolean validateCustomerAccountEmail (Context context, String customerAccountEmail) {
        tbCustomerProfile = new TbCustomerProfileImpl(context);
        String queryValidate = "SELECT count(customerid) FROM tbcustomerprofile WHERE (customeraccount LIKE '" + customerAccountEmail +
                "') OR ( customeremail LIKE '" + customerAccountEmail + "')";
        int count;
        try {
            Cursor cursor = tbCustomerProfile.queryData(queryValidate);
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                cursor.close();
                return  count  == 1;
            }
        } finally {
            tbCustomerProfile.close();
        }
        return false;
    }

    private boolean validatePassword (Context context, String passWord, String customerAccountEmail) {
        tbCustomerProfile = new TbCustomerProfileImpl(context);

        String queryValidate  = "SELECT count(customerid) FROM tbcustomerprofile WHERE customeraccountpassword LIKE '" + passWord + "' AND (customeraccount LIKE '" + customerAccountEmail +
                "' OR customeremail LIKE '" + customerAccountEmail + "')";
        int count;
        try {
            Cursor cursor = tbCustomerProfile.queryData(queryValidate);
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(0);
                Log.d("debug", String.valueOf(count));
                cursor.close();
                return  count  == 1;
            }
        } finally {
            tbCustomerProfile.close();
        }
        return false;
    }
}