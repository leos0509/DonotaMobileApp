package com.donota.donotamobileapp.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.database.impl.TbCustomerProfileImpl;
import com.donota.donotamobileapp.databinding.FragmentAddInformationBinding;
import com.donota.donotamobileapp.utils.DbUtils;
import com.donota.donotamobileapp.utils.PreferenceUtils;
import com.donota.donotamobileapp.utils.ServiceUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddInformationFragment extends Fragment {
    private FragmentAddInformationBinding binding;
    private EditText edtName;
    private EditText edtDOB;
    private EditText edtPhoneNumb;
    private EditText edtEmail;
    private EditText edtAddress;
    private ImageView avatarImageView;
    private Button btnUpdateProfile;

    private int customerId;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtName = binding.edtCustomerName;
        edtDOB = binding.edtCustomerDOB;
        edtPhoneNumb = binding.edtCustomerPhoneNumb;
        edtEmail = binding.edtCustomerEmail;
        edtAddress = binding.edtCustomerAddress;
        avatarImageView = binding.avatarImageView;
        btnUpdateProfile = binding.btnUpdate;

        // Initialize ActivityResultLauncher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData()!= null) {
                        Uri uri = result.getData().getData();
                        try {
                            Bitmap photo = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                            avatarImageView.setImageBitmap(photo);
                        } catch (Exception e) {
                            Log.e("AddInformationFragment", "Error getting bitmap", e);
                        }
                    }
                });

        btnUpdateProfile.setOnClickListener(v -> {
            try {
                updateProfile();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        Spinner spinner = binding.spnProvinces;
        String[] provinces = {"An Giang", "Bà Rịa - Vũng Tàu", /*...*/ "Yên Bái"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, provinces);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });
    }

    private void updateProfile() throws ParseException {
        String name = edtName.getText().toString().trim();
        String dob = edtDOB.getText().toString().trim();
        String phoneNumb = edtPhoneNumb.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        if (phoneNumb.length()!= 10) {
            Toast.makeText(getContext(), "Vui lòng nhập lại số điện thoại", Toast.LENGTH_SHORT).show();
            return;
        }

        if (name.isEmpty() || dob.isEmpty() || email.isEmpty() || address.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = getArguments();
        assert bundle != null;
        String customerAccount = bundle.getString("account");
        String customerPassword = bundle.getString("pass");

        if (insertIntoDb(name, dob, phoneNumb, email, address, customerAccount, customerPassword)){
            Toast.makeText(getContext(), "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
            PreferenceUtils.setCustomerId(getContext(), customerId);
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rootNavFragmentContainer, new HomeNavFragment());
        fragmentTransaction.replace(R.id.homeNavFragmentContainer, new AccountPageFragment());
        fragmentTransaction.commit();
    }

    private boolean insertIntoDb(String name, String dob, String phonenumb, String email, String address, String customerAccount, String customerPassword) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date parsedDate = formatter.parse(dob);
        long convertedDate = ServiceUtils.dateConversion(parsedDate);
        customerId = DbUtils.getCustomerCount(getContext()) + 1;
        TbCustomerProfileImpl tbCustomerProfile = new TbCustomerProfileImpl(getContext());
        String query = "INSERT INTO tbcustomerprofile (\n" +
                "                                  customerid,\n" +
                "                                  customername,\n" +
                "                                  phonenumb,\n" +
                "                                  customeraccount,\n" +
                "                                  customeraccountpassword,\n" +
                "                                  customerdob,\n" +
                "                                  customeremail\n" +
                "                              )\n" +
                "                              VALUES (\n" +
                "                                  '" + customerId+ "',\n" +
                "                                  '" + name+ "',\n" +
                "                                  '" + phonenumb+ "',\n" +
                "                                  '"+ customerAccount+"',\n" +
                "                                  '"+ customerPassword+"',\n" +
                "                                  '"+ convertedDate+"',\n" +
                "                                  '"+ email+"');";
        tbCustomerProfile.close();
        return tbCustomerProfile.execSql(query);
    }
}
