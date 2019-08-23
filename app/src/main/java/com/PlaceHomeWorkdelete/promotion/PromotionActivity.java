package com.PlaceHomeWorkdelete.promotion;

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

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PromotionActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView rvPromotion;
    PromotionAdapter promotionAdapter;
    ArrayList<Result> data = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        init();
        preparetion();
        //  mSwipeRefreshLayout();

    }

    /*private void mSwipeRefreshLayout() {

        mSwipeRefreshLayout = findViewById(R.id.srf_promotion);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(PromotionActivity.this, "Hold on !!!", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 500);
            }
        });
    }*/

    private void preparetion() {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("urlImage", "");
            jsonObject.put("promotionName", "");
            jsonObject.put("placeName", "");
            jsonObject.put("urlLogoPlace", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(PromotionAPI.class).getPromotion(jsonObject).enqueue(new Callback<Promotion>() {
            @Override
            public void onResponse(Call<Promotion> call, Response<Promotion> response) {
                Log.d("", "onResponse: ");
                data.addAll(response.body().result);
                config();
            }

            @Override
            public void onFailure(Call<Promotion> call, Throwable t) {
                Log.d("", "onResponse: ");
                Toast.makeText(PromotionActivity.this, "Check Internet!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void config() {
        promotionAdapter = new PromotionAdapter(data, this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPromotion.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvPromotion.addItemDecoration(dividerItemDecoration);
        rvPromotion.setAdapter(promotionAdapter);

    }

    private void init() {

        rvPromotion = findViewById(R.id.rv_promotion);
        /*mSwipeRefreshLayout = findViewById(R.id.srf_promotion);*/
    }

    public void onRefresh() {

        mSwipeRefreshLayout = findViewById(R.id.srf_promotion);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 500);
            }
        });
    }

}

