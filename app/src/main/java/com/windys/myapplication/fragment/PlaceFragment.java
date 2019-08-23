package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.windys.myapplication.R;
import com.windys.myapplication.recyclerview.ListPlaceResponse1;
import com.windys.myapplication.recyclerview.Place1;
import com.windys.myapplication.recyclerview.PlaceAdapter;
import com.windys.myapplication.recyclerview.ServiceAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceFragment extends Fragment {

    private ArrayList<Place1> data = new ArrayList<>();
    private PlaceAdapter placeAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private View vRoot;
    DividerItemDecoration dividerItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vRoot = inflater.inflate(R.layout.fragment_place, container, false);
        init();
        prepareData();

        return vRoot;
    }

    private void configRV() {
        placeAdapter = new PlaceAdapter(data, getContext());

        linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        /*dividerItemDecoration = new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL);*/
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(placeAdapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void prepareData() {

        JSONObject jsonObject1 = new JSONObject();

        try {
            jsonObject1.put("cateID", "");
            jsonObject1.put("placeID", "");
            jsonObject1.put("searchKey", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://150.95.115.192/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(ServiceAPI.class).getListPlace(jsonObject1).enqueue(new Callback<ListPlaceResponse1>() {
            @Override
            public void onResponse(Call<ListPlaceResponse1> call, Response<ListPlaceResponse1> response) {
                Log.d("", "onResponse: ");
                data.addAll(response.body().result);
                configRV();
            }

            @Override
            public void onFailure(Call<ListPlaceResponse1> call, Throwable t) {
                Log.d("", "onFailure: ");
                Toast.makeText(getActivity(), "Hell from Mars", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {

        recyclerView = vRoot.findViewById(R.id.rv_place_activity);
    }

}
