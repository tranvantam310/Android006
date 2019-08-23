//tim hieu cai nay: // Content in BottomNavigationView    +

package com.windys.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BottomNavigation extends AppCompatActivity {
    private TextView mTextMessage;
    //Fragment fragment = null;
    FrameLayout frameLayout;


    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ContactFragment promotionFragment = new ContactFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_bottom_navigation, promotionFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.navigation_dashboard:

                    //   fragment = new ContactFragment();
                    break;
                case R.id.navigation_notifications:
                    //   fragment = new PlaceFragment();
                    break;
            }
            return false;
        }
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        frameLayout = findViewById(R.id.fl_bottom_navigation);
    }


}
