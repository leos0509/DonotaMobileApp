package com.donota.donotamobileapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.SettingOptionsAdapter;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentAccountPageBinding; // Adjusted import
import com.donota.donotamobileapp.models.SettingOptions;
import com.donota.donotamobileapp.utils.PreferenceUtils;

import java.util.ArrayList;

public class AccountPageFragment extends Fragment {

    private FragmentAccountPageBinding binding;
    private SettingOptionsAdapter settingOptionsAdapter;
    private ArrayList<SettingOptions> settingOptions;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    public AccountPageFragment() {
    }

    public static AccountPageFragment newInstance() {
        AccountPageFragment fragment = new AccountPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccountPageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Khởi tạo ActivityResultLauncher
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == getActivity().RESULT_OK && result.getData() != null) {
                Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                binding.avatarImageView.setImageBitmap(photo);
            }
        });

        initData();
        addEvents();
        return view;
    }

    private void loadData() {
        settingOptions = new ArrayList<>();
        settingOptions.add(new SettingOptions("personal_info", R.drawable.baseline_person, "Tài khoản"));
        settingOptions.add(new SettingOptions("wishlist", R.drawable.baseline_favorite, "Sản phẩm yêu thích"));
        settingOptions.add(new SettingOptions("payment_setting", R.drawable.baseline_credit_card, "Cài đặt thanh toán"));
        settingOptions.add(new SettingOptions("address_setting", R.drawable.baseline_location, "Cài đặt địa chỉ"));
        settingOptions.add(new SettingOptions("policy_setting", R.drawable.baseline_policy, "Chính sách"));
    }

    private void initData() {
        loadData();
        if (getActivity() != null) {
            settingOptionsAdapter = new SettingOptionsAdapter(getActivity(), R.layout.setting_items_layout, settingOptions);
            binding.lvSettingOptions.setAdapter(settingOptionsAdapter);
        }
        int customerId = PreferenceUtils.getCustomerId(getContext());
        String customerEmail = "";
        String customerName = "";
        TbCustomerProfileImpl tbCustomerProfile = new TbCustomerProfileImpl(getContext());
        String query = "SELECT customername, customeremail\n" +
                "  FROM tbcustomerprofile \n" +
                "  WHERE customerid = '" + customerId + "';";
        Cursor cursor = tbCustomerProfile.queryData(query);
        while (cursor.moveToNext()){
            customerName = cursor.getString(0);
            customerEmail = cursor.getString(1);
        }
        binding.txtUserName.setText(customerName);
        binding.txtUserEmail.setText(customerEmail);
    }

    private void addEvents() {
        binding.lvSettingOptions.setOnItemClickListener((parent, view, position, id) -> {
            SettingOptions selectedOption = settingOptions.get(position);
            handleFragmentTransaction(selectedOption.getSettingID());
        });

        binding.imvCamera.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activityResultLauncher.launch(intent);
        });

        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceUtils.setCustomerId(getContext(),0);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.add(R.id.rootNavFragmentContainer, new LoginSignupFragment());
                transaction.commit();
            }
        });
    }

    private void handleFragmentTransaction(String settingID) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        Fragment newFragment = null;

        switch (settingID) {
            case "personal_info":
                newFragment = ProfileFragment.newInstance();
                break;
            case "wishlist":
                newFragment = WishlistPageFragment.newInstance();
                break;
            case "payment_setting":
                newFragment = PaymentSettingsFragment.newInstance();
                break;
            case "address_setting":
                newFragment = AddressSettingsFragment.newInstance();
                break;
            case "policy_setting":
                newFragment = PolicyFragment.newInstance();
                break;
        }

        if (newFragment != null) {
            transaction.add(R.id.rootNavFragmentContainer, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
