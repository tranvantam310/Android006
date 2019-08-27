package com.windys.myapplication.CategoryWork;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.windys.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.RED;

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Category> data = new ArrayList<>();
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    SwipeRefreshLayout spf_home_cate;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        init();
        getData();


    }

    private void config() {
//        categoryAdapter = new CategoryAdapter(this, data);
        categoryAdapter = new CategoryAdapter(this, data, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Category category) {
                Log.d("ABC", "onItemClick: ");
                //
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(categoryAdapter);
    }

    private void getData() {

        // cach 1
        RetrofitClient.getRetrofit().create(CategoryAPI.class)
                .getCategory()
                .enqueue(new Callback<CategoryRespon>() {
                    @Override
                    public void onResponse(Call<CategoryRespon> call, Response<CategoryRespon> response) {
                        Log.d("ABC", "onResponse: ");
                        data.addAll(response.body().result.listCate);

                        config();
                    }

                    @Override
                    public void onFailure(Call<CategoryRespon> call, Throwable t) {
                        Log.d("ABC", "onResponse: ");
                    }
                });
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_category);
        spf_home_cate = findViewById(R.id.spf_home_cate);


        spf_home_cate.setColorSchemeColors(RED);
        spf_home_cate.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spf_home_cate.setRefreshing(false);
                        Toast.makeText(CategoryActivity.this, "Lemon", Toast.LENGTH_SHORT).show();
                    }
                }, 100);
            }
        });
    }
}
