package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
    public LogInFragment() {
    }

    public static LogInFragment newInstance() {
        LogInFragment fragment = new LogInFragment();
        return fragment;
    }

    public interface OnLoginSuccessListener {
        void onLoginSuccess();
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
                                PreferenceUtils.setCustomerId(context, cursor.getInt(0));
                                cursor.close();
                                listener.onLoginSuccess();
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

    // Inside LogInFragment
    private OnLoginSuccessListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginSuccessListener) {
            listener = (OnLoginSuccessListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLoginSuccessListener");
        }
    }

}