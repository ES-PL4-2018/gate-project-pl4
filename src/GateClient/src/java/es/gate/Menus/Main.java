package es.gate.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
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

import java.util.Objects;

public class Main extends AppCompatActivity {

    private ViewPager viewPager;
    private Profile profileFragment;
    private BottomNavigationView bottomNavView;
    private String curAccount;

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

        curAccount = getIntent().getStringExtra("curAccount");

        bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Twitter.initialize(this);



          /*Realm realm = Realm.getDefaultInstance();
        RealmResults<UsersDiscovered> usersDiscovered = realm.where(UsersDiscovered.class).findAll();
        usersDiscovered.addChangeListener(new RealmChangeListener<RealmResults<UsersDiscovered>>() {
            @Override
            public void onChange(RealmResults<UsersDiscovered> usersDiscovered) {
                Toast.makeText(context, "Added new user to list", Toast.LENGTH_SHORT).show();
            }
        });*/


        //new DiscoverContacts(curAccount);

        setupViewPager();
    }

    private void setupViewPager() {

        BottomBarAdapter barAdapter = new BottomBarAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);

        profileFragment = new Profile();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("???????????");

        // Pass the activity result to the fragment, which will then pass the result to the login
        // button.
        Fragment fragment = getSupportFragmentManager().findFragmentById(Objects.requireNonNull(profileFragment.getFragmentID()));
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    public String getCurAccount() {
        return curAccount;
    }
}
