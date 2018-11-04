package es.gate.Menus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.twitter.sdk.android.core.Twitter;
import es.gate.BottomViewNavigation.BottomBarAdapter;
import es.gate.Fragments.Bookmark;
import es.gate.Fragments.Feed;
import es.gate.Fragments.Profile;
import es.gate.R;

public class Main extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomBarAdapter barAdapter;

    private BottomNavigationView bottomNavView;

    private Bookmark bookmarkFragment;
    private Feed feedFragment;
    private Profile profileFragment;

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

        barAdapter = new BottomBarAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);

        profileFragment = new Profile();
        feedFragment = new Feed();
        bookmarkFragment = new Bookmark();

        barAdapter.addFragments(profileFragment);
        barAdapter.addFragments(feedFragment);
        barAdapter.addFragments(bookmarkFragment);

        viewPager.setAdapter(barAdapter);

        bottomNavView.setSelectedItemId(R.id.navigation_dashboard);
        viewPager.setCurrentItem(1);

    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
        super.onBackPressed();
    }
}
