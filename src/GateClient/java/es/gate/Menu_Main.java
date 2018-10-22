package es.gate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.twitter.sdk.android.core.Twitter;

public class Menu_Main extends AppCompatActivity {

    private ViewPager viewPager;
    private BVN_BottomBarAdapter barAdapter;

    private BottomNavigationView bottomNavView;

    private Fragment_Bookmark bookmarkFragment;
    private Fragment_Feed feedFragment;
    private Fragment_Profile profileFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);

                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        bottomNavView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Twitter.initialize(this);

        setupViewPager();
    }

    private void setupViewPager(){

        barAdapter = new BVN_BottomBarAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);

        profileFragment = new Fragment_Profile();
        feedFragment = new Fragment_Feed();
        bookmarkFragment = new Fragment_Bookmark();

        barAdapter.addFragments(profileFragment);
        barAdapter.addFragments(feedFragment);
        barAdapter.addFragments(bookmarkFragment);

        viewPager.setAdapter(barAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
        super.onBackPressed();
    }
}
