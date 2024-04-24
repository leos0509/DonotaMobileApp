package com.donota.donotamobileapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.donota.donotamobileapp.R;
import com.donota.donotamobileapp.databinding.ActivityAddInformationBinding;

public class AddInformationActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ActivityAddInformationBinding binding;
    private EditText edtName;
    private EditText edtDOB;
    private EditText edtPhoneNumb;
    private EditText edtEmail;
    private EditText edtAddress;

    private Button btnUpdateProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddInformationBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        edtName = findViewById(R.id.edtCustomerName);
        edtDOB = findViewById(R.id.edtCustomerDOB);
        edtPhoneNumb = findViewById(R.id.edtCustomerPhoneNumb);
        edtEmail = findViewById(R.id.edtCustomerEmail);
        edtAddress = findViewById(R.id.edtCustomerAddress);
        btnUpdateProfile = findViewById(R.id.btnUpdate);


        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });


        Spinner spinner = binding.spnProvinces;
        String[] provinces = {
                "An Giang", "Bà Rịa - Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
                "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau",
                "Cao Bằng", "Cần Thơ", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai",
                "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương",
                "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hồ Chí Minh", "Hưng Yên", "Khánh Hòa",
                "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An",
                "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
                "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh",
                "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên - Huế", "Tiền Giang", "Trà Vinh",
                "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"
        };


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, provinces);


        // Thiết lập giao diện của Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Thiết lập Adapter cho Spinner
        spinner.setAdapter(adapter);
    }
    private void updateProfile() {
        String name = edtName.getText().toString().trim();
        String dob = edtDOB.getText().toString().trim();
        String phoneNumb = "";
        if (edtPhoneNumb.getText().toString().trim().length() == 10) {
            phoneNumb = edtPhoneNumb.getText().toString().trim();
        } else {
            Toast.makeText(this, "Vui lòng nhập lại số điện thoại", Toast.LENGTH_SHORT).show();
        }
        String email = edtEmail.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        if (name.isEmpty() || dob.isEmpty() || phoneNumb.isEmpty() || email.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
    }
}
