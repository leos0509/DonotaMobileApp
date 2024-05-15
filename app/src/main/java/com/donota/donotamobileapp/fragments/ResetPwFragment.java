package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentResetPwBinding;
import com.donota.donotamobileapp.utils.PreferenceUtils;

public class ResetPwFragment extends Fragment {

    private FragmentResetPwBinding binding;

    public ResetPwFragment() {
        // Required empty public constructor
    }

    public static ResetPwFragment newInstance() {
        return new ResetPwFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResetPwBinding.inflate(inflater, container, false);

        binding.btnConfirmNewPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDb();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.add(R.id.rootNavFragmentContainer, new PasswordResetSuccessFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return binding.getRoot();
    }

    private void updateDb() {
        TbCustomerProfileImpl tbCustomerProfile = new TbCustomerProfileImpl(getContext());
        int customerid = PreferenceUtils.getCustomerId(getContext());
        String updatePasswordQuery = "UPDATE tbcustomerprofile\n" +
                "   SET customeraccountpassword = 'customeraccountpassword',\n" +
                " WHERE customerid = '" +customerid+"'";
        tbCustomerProfile.execSql(updatePasswordQuery);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
