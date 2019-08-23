package com.PlaceHomeWorkdelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.windys.myapplication.R;
import com.windys.myapplication.recyclerview.Place1;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceActivity extends AppCompatActivity {

    RecyclerView rvPlaceActivity;
    ArrayList<Place1> data = new ArrayList<>();
    PlaceAdapter placeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        init();
        prepareData();
    }

    public void config() {

        placeAdapter = new PlaceAdapter(data, this);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvPlaceActivity.setLayoutManager(linearLayoutManager);
        rvPlaceActivity.setAdapter(placeAdapter);
    }

    private void prepareData() {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("cateID", 0);
            jsonObject.put("placeID", 0);
            jsonObject.put("searchKey", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        /*retrofit.create(PlaceAPI.class)
                .getPlaceList(jsonObject)
                .enqueue(new Callback<PlaceList>() {
                    @Override
                    public void onResponse(Call<PlaceList> call, Response<PlaceList> response) {
                        data.addAll(response.body().result);
                        config();
                    }


                    @Override
                    public void onFailure(Call<PlaceList> call, Throwable t) {

                    }
                });*/

        retrofit.create(PlaceAPI.class)
                .getPlaceList(jsonObject)
                .enqueue(new Callback<PlaceList>() {
                    @Override
                    public void onResponse(Call<PlaceList> call, Response<PlaceList> response) {


                    }

                    @Override
                    public void onFailure(Call<PlaceList> call, Throwable t) {

                    }
                });
    }

    private void init() {
        rvPlaceActivity = findViewById(R.id.rv_place_activity);
    }
}
