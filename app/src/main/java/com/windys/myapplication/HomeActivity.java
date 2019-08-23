package com.windys.myapplication;

import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {
    TextView tvName, tvPhone, tvFirstTitle;
    ImageView imgFirstNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        getData();
    }

   /* private void init1() {
        tvChiTiet = findViewById(R.id.tv_chitiet);
        tvTitle = findViewById(R.id.tv_title);
        imgActivityHome = findViewById(R.id.img_activity_home);
    }*/


    private void getData() {
       /* Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");*/
   //     tvName.setText(user.name);

        /*try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            JSONObject homeJSON = stringToJson(strData);
            JSONObject resulJSON = homeJSON.getJSONObject("result");
            JSONObject cusDetailJSON = resulJSON.getJSONObject("customerDetail");

            String phone = cusDetailJSON.getString("phone");
            String name = cusDetailJSON.getString("customerName");

            tvName.setText(name);
            tvphone.setText(phone);
            JSONArray listNewJSON = resulJSON.getJSONArray("listNews");
            JSONObject firstNewJSON = listNewJSON.getJSONObject(0);
        } catch (Exception e) {
             e.printStackTrace();
        }*/

        /*try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);

            String strData = new String(b);
            JSONObject homeJSON = stringToJson(strData);
            JSONObject resulJSON = homeJSON.getJSONObject("result");
            JSONObject cusDetailJSON = resulJSON.getJSONObject("customerDetail");

            String phone = cusDetailJSON.getString("phone");
            String name = cusDetailJSON.getString("customerName");

            tvName.setText(name);
            tvPhone.setText(phone);

            JSONArray listNewJSON = resulJSON.getJSONArray("listNews");
            JSONObject firstNewsJSON = listNewJSON.getJSONObject(0);

            String urlImage = firstNewsJSON.getString("urlImage");
            tvFirstTitle.setText(firstNewsJSON.getString("title"));
            Picasso.get().load("https://media1.tenor.com/images/30d1780ab4c085f53e42d025e8fdb51d/tenor.gif?itemid=11568518").into(imgFirstNews);

        } catch (Exception e) {
             e.printStackTrace();
        }*/
    }

      /*  JSONObject stringToJson(String strData){
            JSONObject jsonHome;
            try {
                jsonHome = new JSONObject(strData);
                return jsonHome;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }*/


        private void init () {

            tvName = findViewById(R.id.tv_name);
            tvPhone = findViewById(R.id.tv_phone);
            imgFirstNews = findViewById(R.id.img_activity_home);
            tvFirstTitle = findViewById(R.id.tv_first_title);


            /* Xet man hinh SlapActivity
            tvLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               *//* Intent intent = new Intent(HomeActivity.this, SplashActivity.class);

                startActivity(intent);
                finish();*//*

                    SharedPreferences sharedPreferences = getSharedPreferences(Key.KEY_GETSHAREDFEREND, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(Key.KEY_LOGIN, false);
                    editor.apply();
                    Log.d("ABC1", "HomeActivity");

                    Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
                    startActivity(intent);
                }
            });*/
        }
    }


