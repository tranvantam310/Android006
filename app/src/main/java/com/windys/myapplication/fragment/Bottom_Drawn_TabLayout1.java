package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.windys.myapplication.R;

public class Bottom_Drawn_TabLayout1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__drawn__tab_layout1);

        init();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_cate1:
                    displayFragment(new ContactFragment());
                    break;

                case R.id.nav_place1:
                    displayFragment(new ContactFragment());
                    break;

                case R.id.nav_contact1:
                    displayFragment(new ContactFragment());
                    break;

                case R.id.nav_promotion1:
                    displayFragment(new ContactFragment());
                    break;
            }
            return true;
        }
    };


    private void init() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav);
        frameLayout = findViewById(R.id.fg_3);
        bottomNavigationView = findViewById(R.id.nav_bottom);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_cate1:
                displayFragment(new CategoryFragment());
                break;

            case R.id.nav_place1:
                displayFragment(new PlaceFragment());
                break;

            case R.id.nav_contact1:
                displayFragment(new ContactFragment());
                break;

            case R.id.nav_promotion1:
                displayFragment(new PromotionFragment());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START, true);

        return true;
    }


    void displayFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fg_3, fragment);
        fragmentTransaction.commit();

    }

    // bottom navigation
}
