package com.windys.myapplication.ListContact;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.windys.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactActivity extends AppCompatActivity {

    ArrayList<Contact> data = new ArrayList<Contact>();
    ContactAdapter contactAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mSwipeRefreshLayout();

        init();
        preparetion();
       // configRV();

    }

    public void mSwipeRefreshLayout() {
        mSwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(ContactActivity.this, "Waiting....", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setColorSchemeColors(Color.RED);
                        Collections.shuffle(data, new Random(System.currentTimeMillis()));
                        mSwipeRefreshLayout.setRefreshing(false);

                    }
                }, 500);
            }
        });
    }

    private void configRV() {
       /* contactAdapter = new ContactAdapter(this, data, new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                Toast.makeText(ContactActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });*/

        contactAdapter = new ContactAdapter(this, data, new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + contact.getPhone()));
                startActivity(intent);

            }
        });

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(contactAdapter);
    }

    private void preparetion() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("userAPI1", "userAPI1");
            jsonObject.put("passAPI1", "userAPI1");
            jsonObject.put("contactID1", "userAPI1");
            jsonObject.put("searchKey1", "userAPI1");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // http://150.95.115.192/api/Service/GetListContact"
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        retrofit.create(ServiceAPIContact.class)
                .getListContact(jsonObject)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("ABC", "onResponse: ");
                            String res = response.body().string();

                            JSONObject jsonObject = new JSONObject(res);
                            JSONArray jsonArrayResult = jsonObject.getJSONArray("result");

                            for (int i = 0; i < jsonArrayResult.length(); i++) {

                                JSONObject jsonObject1 = jsonArrayResult.getJSONObject(i);

                                String name = jsonObject1.getString("name");
                                String phone = jsonObject1.getString("phone");

                                Contact contact = new Contact(name, phone);
                                data.add(contact);


                            }

                            configRV();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("ABC1", "onFailure: ");
                        Toast.makeText(ContactActivity.this, "Please. Check the Internet !!!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void init() {

        recyclerView = findViewById(R.id.rv_contact);
    }
}
