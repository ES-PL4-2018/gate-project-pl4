package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.gate.BottomViewNavigation.BottomBarAdapter;
import es.gate.R;

public class Discovery extends Fragment {

    private View discoveryView;
    private Discovery_Add discoveryAddFragment;
    private Discovery_Contact discoveryContactFragment;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        discoveryView = inflater.inflate(R.layout.menu_discovery, container, false);

        setupDiscoveryViewPager();

        return discoveryView;
    }

    public View getView(){
        return discoveryView;
    }

    public void discoveryClick(int event){

        switch(event){
            case 0: {
                viewPager.setCurrentItem(1);
                break;
            }
            case 1:{
                viewPager.setCurrentItem(0);
                //TODO
                break;
            }
        }
    }

    private void setupDiscoveryViewPager(){

        BottomBarAdapter barAdapter = new BottomBarAdapter(getChildFragmentManager());
        viewPager = discoveryView.findViewById(R.id.discoveryViewPager);

        discoveryAddFragment = new Discovery_Add();
        discoveryContactFragment = new Discovery_Contact();

        barAdapter.addFragments(discoveryContactFragment);
        barAdapter.addFragments(discoveryAddFragment);

        viewPager.setAdapter(barAdapter);
    }

}
