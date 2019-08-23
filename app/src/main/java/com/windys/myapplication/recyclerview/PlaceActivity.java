package com.windys.myapplication.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.windys.myapplication.R;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceActivity extends AppCompatActivity {

    ArrayList<Place1> data = new ArrayList<>();
    public PlaceAdapter placeAdapter = new PlaceAdapter(data, this);
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_activity);

        init();
        prepareData();

    }

    private void configRV() {
        placeAdapter = new PlaceAdapter(data, this);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(placeAdapter);
    }

    private void prepareData() {
        JSONObject jsonObject = new JSONObject();

        Retrofit retrofit = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();

        try {
            jsonObject.put("urlLogoPlace", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        retrofit.create(ServiceAPI.class).getListPlace(jsonObject).enqueue(new Callback<ListPlaceResponse1>() {
            @Override
            public void onResponse(Call<ListPlaceResponse1> call, Response<ListPlaceResponse1> response) {
                data.addAll(response.body().result);
                configRV();
            }

            @Override
            public void onFailure(Call<ListPlaceResponse1> call, Throwable t) {
                Toast.makeText(PlaceActivity.this, "Check the Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_place_activity);
    }

}

