package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.PlaceHomeWorkdelete.promotion.Promotion;
import com.PlaceHomeWorkdelete.promotion.PromotionAPI;
import com.PlaceHomeWorkdelete.promotion.PromotionAdapter;
import com.PlaceHomeWorkdelete.promotion.Result;
import com.windys.myapplication.CategoryWork.RetrofitClient;
import com.windys.myapplication.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    PromotionAdapter promotionAdapter;
    ArrayList<Result> data = new ArrayList<>();
    RecyclerView recyclerView;
    View view;
    SwipeRefreshLayout swipeRefreshLayout;
    //DividerItemDecoration dividerItemDecoration;
    LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_promotion, container, false);

        init();
        preparetion();

        return view;
    }


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

        RetrofitClient.getRetrofit().create(PromotionAPI.class)
                .getPromotion(jsonObject).enqueue(new Callback<Promotion>() {
            @Override
            public void onResponse(Call<Promotion> call, Response<Promotion> response) {
                Log.d("", "onResponse: ");
                data.addAll(response.body().result);
                configRV();
            }

            @Override
            public void onFailure(Call<Promotion> call, Throwable t) {
                Log.d("", "onResponse: ");
            }
        });
    }

    private void configRV() {

        promotionAdapter = new PromotionAdapter(data, /*getActivity()*/ getContext());

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);

        //      recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(promotionAdapter);

    }

    private void init() {
        recyclerView = view.findViewById(R.id.rv_promotion_fragment);
        swipeRefreshLayout = view.findViewById(R.id.srf_promotion);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                Collections.shuffle(data, new Random(System.currentTimeMillis()));
            }
        }, 500);
    }
}