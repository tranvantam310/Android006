package com.windys.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.windys.myapplication.R;

// Boss 006 do that
public class BottomTabActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navBottom;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);

        init();
        configNav();
    }

    private void configNav() {
        navBottom.setOnNavigationItemSelectedListener(this);
        displayFragment(new PromotionFragment());
        navBottom.setSelectedItemId(R.id.nav_promotion);
    }

    private void init() {

        navBottom = findViewById(R.id.nav_bottom);
        container = findViewById(R.id.container);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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

        return true;
    }

    void displayFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}
