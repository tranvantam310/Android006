package com.windys.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //  TextView tvHello = findViewById(R.id.tv_hello);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }


    public void init() {
        // khai cho nao biet dau la textview co chu Hello
        TextView tvHello;
        tvHello = findViewById(R.id.tv_hello);

        tvHello.setText("Hello");

        final EditText edtPhoneNumber;
        edtPhoneNumber = findViewById(R.id.edt_phone_number1);
        edtPhoneNumber.setText("22223393993");


        TextView tvLoginNumber;
        tvLoginNumber = findViewById(R.id.tv_login_number);
        tvLoginNumber.setText("Log in by phone number");

        TextView tvLogIn;
        tvLogIn = findViewById(R.id.tv_login);
        tvLogIn.setText("Log in");

        TextView tvLoginSocial;
        tvLoginSocial = findViewById(R.id.tv_login_social);
        tvLoginSocial.setText("Social Login");

        TextView tvLogin1;
        tvLogin1 = findViewById(R.id.tv_login1);
        tvLogin1.setText("Login");

        RelativeLayout rlLoginButton;
        rlLoginButton = findViewById(R.id.rl_login_button);
        rlLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                int phoneNumberLength = phoneNumber.length();

                if ((phoneNumberLength) > 9) {
                    Intent intent = new Intent(LoginActivity.this, UpdataUserInfoActivity.class);

                    // them du lieu vao trong intent(nhet thang phoneNumber vao itent)
                    intent.putExtra("phoneNumberPassword", phoneNumber);

                    // Luu trang thai dang nhap
                //    setLogin();
                   startActivity(intent);

                    LoginActivity.this.finish(); // equal  finish();


                } else {
                    Toast.makeText(LoginActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                    edtPhoneNumber.setError("Phone number must be length than");
                }
            }
        });
    }

    void setLogin(){

        /*SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Key.KEY_LOGIN, true);
        editor.apply();*/

        SharedPreferences sharedPreferences = getSharedPreferences(/*"dekko"*/ Key.KEY_GETSHAREDFEREND, MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean(Key.KEY_LOGIN, true);
        editor.apply();
    }
}
