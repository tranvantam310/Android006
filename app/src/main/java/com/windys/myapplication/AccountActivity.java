package com.windys.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.windys.myapplication.recyclerview.History;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    Toolbar toolbar;
    RelativeLayout rlLogout;
    List<History> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setToolbar();

        init();
    }

    private void init() {
        rlLogout = findViewById(R.id.rl_logout);
    }

    private void setToolbar() {

        rlLogout = findViewById(R.id.rl_logout);
        rlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // myself write
                /*SharedPreferences sharedPreferences = getSharedPreferences(Key.KEY_GETSHAREDFEREND, MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean(*//*"isLogin"*//*Key.KEY_LOGIN, false);

                Intent intent = new Intent(AccountActivity.this, SplashActivity.class);
                startActivity(intent);
                finish();*/

                // write again
                SharedPreferences sharedPreferences = getSharedPreferences(Key.KEY_GETSHAREDFEREND, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();


                editor.putBoolean(Key.KEY_LOGIN, false);
                editor.apply();
               // finish();


                Intent intent = new Intent(AccountActivity.this, SplashActivity.class);
                startActivity(intent);

                finish();


            }
        });
        
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Tai khoan");
        toolbar.setNavigationIcon(R.drawable.ic_comback_infor);
        setSupportActionBar(toolbar);
    }

}
