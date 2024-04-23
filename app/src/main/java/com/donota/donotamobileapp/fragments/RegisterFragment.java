package com.donota.donotamobileapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.database.impl.CustomerDatabaseImpl;
import com.donota.donotamobileapp.databinding.FragmentRegisterBinding;
import com.donota.donotamobileapp.models.Customers;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        binding.btnConfirmSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerUserName = binding.edtUserName.getText().toString();
                String customerEmail = binding.edtEmail.getText().toString();
                String customerPassword = binding.edtInputPw.getText().toString();
                String confirmPassword = binding.edtReInputPw.getText().toString();

                // Kiểm tra xác nhận mật khẩu
                if (!customerPassword.equals(confirmPassword)) {
                    // Hiển thị thông báo lỗi cho người dùng
                    Toast.makeText(getActivity(), "Mật khẩu xác nhận không trùng khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo một đối tượng Customer
                Customers customer = new Customers(null, null, customerEmail, customerUserName, null, null, null, null, customerPassword, null, null, null);

                // Lưu thông tin của khách hàng vào cơ sở dữ liệu
                CustomerDatabaseImpl customerDatabase = new CustomerDatabaseImpl(getActivity());
                boolean isSuccess = customerDatabase.execSql("INSERT INTO " + CustomerDatabaseImpl.TBL_CUSTOMER_PROFILE +
                        " (" + CustomerDatabaseImpl.COL_CUSTOMER_ID + ", " + CustomerDatabaseImpl.COL_CUSTOMER_NAME + ", " +
                        CustomerDatabaseImpl.COL_CUSTOMER_EMAIL + ", " + CustomerDatabaseImpl.COL_CUSTOMER_USERNAME + ", " +
                        CustomerDatabaseImpl.COL_CUSTOMER_PHONENUMB + ", " + CustomerDatabaseImpl.COL_CUSTOMER_ADDRESS + ", " +
                        CustomerDatabaseImpl.COL_CUSTOMER_PURCHASE_HISTORY + ", " + CustomerDatabaseImpl.COL_CUSTOMER_ACCOUNT + ", " +
                        CustomerDatabaseImpl.COL_CUSTOMER_ACCOUNT_PASSWORD + ", " + CustomerDatabaseImpl.COL_CUSTOMER_CART + ", " +
                        CustomerDatabaseImpl.COL_CUSTOMER_WISHLIST + ", " + CustomerDatabaseImpl.COL_CUSTOMER_DOB + ") " +
                        "VALUES ('" + customer.getCustomerUsername() + "', '" + customer.getCustomerEmail() + "', '" +
                        customer.getCustomerPassword() + "', NULL, NULL, NULL, NULL, NULL, NULL)");

                // Kiểm tra kết quả và hiển thị thông báo cho người dùng
                if (isSuccess) {
                    Toast.makeText(getContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    // Nếu cần, chuyển người dùng đến màn hình đăng nhập hoặc màn hình chính của ứng dụng
                } else {
                    Toast.makeText(getContext(), "Đã xảy ra lỗi khi đăng ký!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
}