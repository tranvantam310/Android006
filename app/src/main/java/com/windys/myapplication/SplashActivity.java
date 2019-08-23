package com.windys.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.windys.myapplication.fragment.BottomTabActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        router();
    }

    void router() {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
/*
                SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
                // boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
                boolean isLogin = sharedPreferences.getBoolean(Key.KEY_LOGIN, false);

                Toast.makeText(SplashActivity.this, "" + isLogin, Toast.LENGTH_SHORT).show();
                if (isLogin) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }*/
              /*  SharedPreferences sharedPreferences = getSharedPreferences(Key.KEY_GETSHAREDFEREND, MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean(Key.KEY_LOGIN, false);
                if (isLogin) {*/

                    Intent intent = new Intent(SplashActivity.this, BottomTabActivity.class);
                    startActivity(intent);
                    finish();

                /*} else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }*/

            }


        }, 1000);
    }
}
