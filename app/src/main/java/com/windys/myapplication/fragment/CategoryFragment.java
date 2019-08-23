package com.windys.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.windys.myapplication.CategoryWork.Category;
import com.windys.myapplication.CategoryWork.CategoryAPI;
import com.windys.myapplication.CategoryWork.CategoryRespon;
import com.windys.myapplication.CategoryWork.RetrofitClient;
import com.windys.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    ArrayList<Category> data = new ArrayList<>();
    CategoryAdapterFragment categoryAdapterFragment;
    RecyclerView recyclerView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        init();
        prepation();

        return view;
    }

    private void prepation() {

        RetrofitClient.getRetrofit().create(CategoryAPI.class).getCategory().enqueue(new Callback<CategoryRespon>() {
            @Override
            public void onResponse(Call<CategoryRespon> call, Response<CategoryRespon> response) {
                Log.d("ABC", "onResponse: ");
                data.addAll(response.body().result.listCate);
                configRV();
            }

            @Override
            public void onFailure(Call<CategoryRespon> call, Throwable t) {
                Toast.makeText(getContext(), "Check Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configRV() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);

        categoryAdapterFragment = new CategoryAdapterFragment(data, getContext());

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(categoryAdapterFragment);
    }

    private void init() {
        recyclerView = view.findViewById(R.id.rv_contact_fragment);
    }


}
