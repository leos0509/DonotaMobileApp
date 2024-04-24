package com.donota.donotamobileapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.adapters.SettingOptionsAdapter;
import com.donota.donotamobileapp.databinding.FragmentAccountPageBinding; // Adjusted import
import com.donota.donotamobileapp.models.SettingOptions;

import java.util.ArrayList;

public class AccountPageFragment extends Fragment {

    private FragmentAccountPageBinding binding; // Adjusted to use the correct binding class
    private SettingOptionsAdapter settingOptionsAdapter;
    private ArrayList<SettingOptions> settingOptions;

    public AccountPageFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccountPageBinding.inflate(inflater, container, false); // Adjusted to use the correct binding class
        View view = binding.getRoot();

        loadData();
        addEvents();
        return view;
    }

    private void initData() {
        settingOptions = new ArrayList<>();
        settingOptions.add(new SettingOptions("personal_info", R.drawable.baseline_person, "Tài khoản"));
        settingOptions.add(new SettingOptions("wishlist", R.drawable.material_symbols__favorite_outline, "Sản phẩm yêu thích"));
        settingOptions.add(new SettingOptions("payment_setting", R.drawable.baseline_credit_card, "Cài đặt thanh toán"));
        settingOptions.add(new SettingOptions("address_setting", R.drawable.baseline_location, "Cài đặt địa chỉ"));
        settingOptions.add(new SettingOptions("policy_setting", R.drawable.baseline_policy, "Chính sách"));
    }

    private void loadData() {
        initData();
        if (getActivity() != null) {
            settingOptionsAdapter = new SettingOptionsAdapter(getActivity(), R.layout.setting_items_layout, settingOptions);
            binding.lvSettingOptions.setAdapter(settingOptionsAdapter);
        }
    }

    private void addEvents() {
        binding.lvSettingOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SettingOptions selectedOption = settingOptions.get(position);
                handleFragmentTransaction(selectedOption.getSettingID());
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
