package com.windys.myapplication.fragment;

// tự làm
// thử làm sau buổi học thêm

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.windys.myapplication.R;

public class BottomDelete extends AppCompatActivity {

    FrameLayout frameLayout;
    Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:

                    /*PromotionFragment promotionFragment = new PromotionFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_delete, promotionFragment);
                    fragmentTransaction.commit();*/

                    fragment = new PromotionFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_delete, fragment);
                    fragmentTransaction.commit();


                    return true;
                case R.id.navigation_dashboard:

                    fragment = new ContactFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fl_delete, fragment);
                    fragmentTransaction1.commit();


                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_delete);
        frameLayout = findViewById(R.id.fl_delete);

        setDefaultKeyMode(DEFAULT_KEYS_DIALER);

        fragment = new PromotionFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_delete, fragment);
        ft.commit();

        BottomNavigationView navView = findViewById(R.id.nav_view_delete);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
