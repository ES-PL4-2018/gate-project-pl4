package es.gate.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.gate.BottomViewNavigation.BottomBarAdapter;
import es.gate.Discover.DiscoveryProcess;
import es.gate.Menus.Main;
import es.gate.R;

import java.util.Objects;

public class Discovery extends Fragment {

    private View discoveryView;
    private Discovery_Add discoveryAddFragment;
    private Discovery_List discoveryContactFragment;
    private Discovery_Profile discoveryProfileFragment;
    private ViewPager viewPager;
    @SuppressLint("HandlerLeak")
    private final Handler discoveryHandler = new Handler() {

        @Override
        public void handleMessage(Message message) {

            int response = message.getData().getInt("clickEvent");

            discoveryEvent(response);

        }
    };
    private Main parent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        discoveryView = inflater.inflate(R.layout.menu_discovery, container, false);

        parent = (Main) getActivity();

        new DiscoveryProcess(Objects.requireNonNull(parent).getCurAccount(), this);

        setupDiscoveryViewPager();

        return discoveryView;
    }

    public View getView() {
        return discoveryView;
    }

    public void discoveryEvent(int event) {

        switch (event) {
            case 0: {
                viewPager.setCurrentItem(0);
                break;
            }
            case 1: {
                viewPager.setCurrentItem(1);
                break;
            }
            case 2: {
                viewPager.setCurrentItem(2);
                break;
            }
            case 3: {
                viewPager.setCurrentItem(1);
                discoveryContactFragment.updateView();
                break;
            }
            case 4: {
                discoveryAddFragment.updateView();
                break;
            }
        }
    }

    public void viewUserProfile(String profileOrcid) {

        discoveryProfileFragment.updateInfo(profileOrcid);
        discoveryEvent(0);
    }

    private void setupDiscoveryViewPager() {

        BottomBarAdapter barAdapter = new BottomBarAdapter(getChildFragmentManager());
        viewPager = discoveryView.findViewById(R.id.discoveryViewPager);

        discoveryAddFragment = new Discovery_Add();
        discoveryContactFragment = new Discovery_List();
        discoveryProfileFragment = new Discovery_Profile();

        barAdapter.addFragments(discoveryProfileFragment);
        barAdapter.addFragments(discoveryContactFragment);
        barAdapter.addFragments(discoveryAddFragment);

        viewPager.setAdapter(barAdapter);
        viewPager.setCurrentItem(1);
    }

    public String getCurAccount() {

        return parent.getCurAccount();
    }

    public Handler getDiscoveryHandler() {
        return discoveryHandler;
    }
}
