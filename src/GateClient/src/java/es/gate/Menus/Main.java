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
import es.gate.Fragments.Discovery;
import es.gate.Fragments.Feed;
import es.gate.Fragments.Profile;
import es.gate.R;

public class Main extends AppCompatActivity {

    private ViewPager viewPager;

    private BottomNavigationView bottomNavView;

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
                case R.id.navigation_discovery:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Twitter.initialize(this);

        setupViewPager();
    }

    private void setupViewPager(){

        BottomBarAdapter barAdapter = new BottomBarAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);

        Profile profileFragment = new Profile();
        Feed feedFragment = new Feed();
        Discovery discoveryFragment = new Discovery();
        Bookmark bookmarkFragment = new Bookmark();

        barAdapter.addFragments(profileFragment);
        barAdapter.addFragments(feedFragment);
        barAdapter.addFragments(discoveryFragment);
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
