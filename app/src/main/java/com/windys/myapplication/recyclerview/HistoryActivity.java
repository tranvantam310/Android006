package com.windys.myapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.windys.myapplication.R;
import com.windys.myapplication.Util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    List<History> data = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    HistoryAdapter historyAdapter = new HistoryAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        init();
        prepareData();
        configRv();
    }

    private void init() {
        rvHistory = findViewById(R.id.rv_history);
    }

    void prepareData() {

        // doc file history. json
        // lay Jsonarry : result
        // for jsonArray -> lay tung json


        /*
       data = new ArrayList<>();
         for (int i = 0; i < 100; i++) {
            History history = new History("Title" + i, i);
            data.add(history);
        }*/

        // noi dung tren lop
        //  JSONObject jsontHistory = Util.fileToJson(R.raw.history, this);
        JSONObject jsontHistory = Util.fileToJson(R.raw.history, this);

        try {
            JSONArray jsonArrayResult = jsontHistory.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {

                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);

                String title = jsonObject.getString("title");
                String icon = jsonObject.getString("icon");
                int point = jsonObject.getInt("point");

                History history = new History(title, icon, point);
                data.add(history);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


       /* try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.history);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);

            String strData = new String(b);
            JSONObject homeJSON = stringToJson(strData);
            JSONArray resultJSON = homeJSON.getJSONArray("result");
          //  Toast.makeText(this, homeJSON +"", Toast.LENGTH_SHORT).show();

            for (int i = 0; i < resultJSON.length(); i++) {


            JSONObject jsonObject = resultJSON.getJSONObject(0);
            int historyID = jsonObject.getInt("historyID");
            int customerID = jsonObject.getInt("customerID");
            String customerName = jsonObject.getString("customerName");
            int point = jsonObject.getInt("point");
            String addpointCode = jsonObject.getString("addpointCode");
            String code = jsonObject.getString("code");
            String createDate = jsonObject.getString("createDate");
            String createDateStr = jsonObject.getString("createDateStr");
            int typeAdd = jsonObject.getInt("typeAdd");
            int type = jsonObject.getInt("type");
            String title = jsonObject.getString("title");
            int balance = jsonObject.getInt("balance");
            String icon = jsonObject.getString("icon");

            // Log.d("ABC", historyID + "");
            }


        } catch (Exception e) {
             e.printStackTrace();

        }*/

    }

   /* JSONObject stringToJson(String strData){
        JSONObject jsonHome;
        try {
            jsonHome = new JSONObject(strData);
            return jsonHome;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    void configRv() {
        // HistoryAdapter historyAdapter = new HistoryAdapter();

        // historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;

/*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
*/

        linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        //rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setLayoutManager(new GridLayoutManager(this, 3));
        rvHistory.setAdapter(historyAdapter);
    }
}
