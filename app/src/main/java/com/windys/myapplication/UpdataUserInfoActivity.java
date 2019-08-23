package com.windys.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdataUserInfoActivity extends AppCompatActivity {
    EditText edtPhoneNumber, edtName, edtDob, edtEmail, edtProvince;
    Button btnSave;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_user_info);

        init();
        getData();

    }

    private void getData() {

        Intent intent = getIntent();
        String phoneNunber = intent.getStringExtra("phoneNumberPassword");
        edtPhoneNumber.setText(phoneNunber);
    }

    void prepareData() {
        //User user;

        // lay cac gia tri ma nguoi dung nhap vao

        String name = edtName.getText().toString();
        String province = edtProvince.getText().toString();
        String dob = edtDob.getText().toString();
        String email = edtEmail.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();


        /*user.setName(name);
        user.province = province;
        user.dOB = dob;
        user.email = email;
        user.phoneNumber = phoneNumber;*/

        user = new User(name,phoneNumber, dob,email,province);


        /*Intent intent;
        intent = new Intent(UpdataUserInfoActivity.this, HomeActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

        finish();*/

        Intent intent;
        intent = new Intent(UpdataUserInfoActivity.this, AccountActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);

        finish();

    }


    void init() {

        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtName = findViewById(R.id.edt_name);
        edtDob = findViewById(R.id.edt_dob);
        edtEmail = findViewById(R.id.edt_email);
        edtProvince = findViewById(R.id.edt_province);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();

            }
        });

    }
}
