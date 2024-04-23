package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.donota.donotamobileapp.activities.AccountActivity;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentRegisterBinding;
import com.donota.donotamobileapp.models.CustomerDto;
import com.donota.donotamobileapp.utils.DbUtils;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentRegisterBinding binding;
    public RegisterFragment() {
        // Required empty public constructor
    }

    TbCustomerProfileImpl tbCustomerProfile;

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        binding.btnConfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                String customerAccount = binding.edtUserName.getText().toString();
                String customerEmail = binding.edtEmail.getText().toString();
                String customerPassword = binding.edtInputPw.getText().toString();
                String confirmPassword = binding.edtReInputPw.getText().toString();

                if (verifyEmailInput(context, customerEmail) && verifyCustomerAccountInput(context, customerAccount)) {
                    if (!customerPassword.equals(confirmPassword)) {
                        Toast.makeText(getActivity(), "Mật khẩu xác nhận không trùng khớp!", Toast.LENGTH_SHORT).show();
                    } else {
                        PreferenceUtils.setUserAccount(context, customerAccount);
                        PreferenceUtils.setUserAccount(getActivity(), customerAccount);
                        Intent intent = new Intent(getActivity(), AccountActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getContext(), "Đã xảy ra lỗi khi đăng ký!", Toast.LENGTH_SHORT).show();;
                }

            }
        });
        return binding.getRoot();
    }
    private boolean verifyEmailInput (Context context, String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "(gmail\\.com|uel\\.edu\\.vn|yahoo\\.com|st\\.uel\\.edu\\.vn)$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            tbCustomerProfile = new TbCustomerProfileImpl(context);
            try {
                String queryCustomerEmail = "SELECT count(customeremail) FROM tbcustomerprofile WHERE customeremail LIKE '" + email + "'";
                Cursor cursor = tbCustomerProfile.queryData(queryCustomerEmail);
                if (cursor != null && cursor.moveToFirst()) {
                    int count = cursor.getInt(0);
                    cursor.close();
                    return count == 0;
                }
            } finally {
                tbCustomerProfile.close();
            }
        }
        return false;
    }

    private boolean verifyCustomerAccountInput (Context context, String customerAccount) {
        tbCustomerProfile = new TbCustomerProfileImpl(context);
        try {
            String queryCustomerAccount = "SELECT count(customeraccount) FROM tbcustomerprofile WHERE customeraccount LIKE '" + customerAccount + "'";
            Cursor cursor = tbCustomerProfile.queryData(queryCustomerAccount);
            if (cursor != null && cursor.moveToFirst()) {
                int count = cursor.getInt(0);
                cursor.close();
                return count == 0;
            }
        } finally {
            tbCustomerProfile.close();
        }
        return false;
    }
}
