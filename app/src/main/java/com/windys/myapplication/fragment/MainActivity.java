package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.windys.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager vpMain;
    ArrayList<Fragment> data = new ArrayList<>();
    TabLayout tabHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        prepareData();
        config();
    }

    private void config() {

        MainViewpagerAdapter mainViewpagerAdapter =
                new MainViewpagerAdapter(getSupportFragmentManager(), data, this);
        vpMain.setOffscreenPageLimit(data.size());
        vpMain.setAdapter(mainViewpagerAdapter);
    }

    private void prepareData() {
        PlaceFragment placeFragment = new PlaceFragment();
        ContactFragment contactFragment = new ContactFragment();
        PromotionFragment promotionFragment = new PromotionFragment();

        data.add(contactFragment);
        data.add(placeFragment);
        data.add(promotionFragment);

        tabHeader.setupWithViewPager(vpMain);
    }

    private void init() {
        vpMain = findViewById(R.id.vp_main);
        tabHeader = findViewById(R.id.tab_header);
    }
}
