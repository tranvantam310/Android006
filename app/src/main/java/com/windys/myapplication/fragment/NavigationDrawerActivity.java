package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.windys.myapplication.R;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // de navigation duoi Toolbar

    NavigationView nav;
    DrawerLayout drawerLayout;
    FrameLayout container;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        
        init();
        configMenu();
    }

    private void configMenu() {
        nav.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        toggle.setDrawerIndicatorEnabled(true);

        drawerLayout.setDrawerListener(toggle);

    }

    private void init() {
        nav = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.drawer_layout);
        container = findViewById(R.id.container);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toggle != null){
            toggle.syncState();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Log.d("", "onNavigationItemSelected: ");
        switch (menuItem.getItemId()) {
            case R.id.nav_cate: {

                displayFragment(new CategoryFragment());
                break;
            }
            case R.id.nav_place: {

                /*PlaceFragment placeFragment = new PlaceFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, placeFragment);
                fragmentTransaction.commit();*/

                displayFragment(new PlaceFragment());

                break;
            }
            case R.id.nav_contact: {
                displayFragment(new ContactFragment());
                break;
            }
            default:
//                Toast.makeText(this, "nav_promotion", Toast.LENGTH_SHORT).show();

                displayFragment(new PromotionFragment());
                break;
        }

        drawerLayout.closeDrawer(Gravity.START, true);


        return true;
    }

    void displayFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}
