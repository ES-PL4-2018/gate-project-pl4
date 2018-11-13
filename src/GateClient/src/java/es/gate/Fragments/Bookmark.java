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
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Main;
import es.gate.R;
import io.realm.Realm;

public class Bookmark extends Fragment {

    private View bookmarkView;
    private Bookmark_List bookmarkListFragment;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        bookmarkView = inflater.inflate(R.layout.menu_bookmark, container, false);

        setupBookmarkViewPager();

        return bookmarkView;
    }

    public View getView(){
        return bookmarkView;
    }

    public void bookmarkClick(int event){

        switch(event){
            case 0: {
                viewPager.setCurrentItem(1);
                break;
            }
            case 1:{
                viewPager.setCurrentItem(0);
                bookmarkListFragment.updateData();
                break;
            }
            case -1:{
                viewPager.setCurrentItem(0);
                break;
            }
        }
    }

    private void setupBookmarkViewPager(){

        BottomBarAdapter barAdapter = new BottomBarAdapter(getChildFragmentManager());
        viewPager = bookmarkView.findViewById(R.id.bookmarkViewPager);


        bookmarkListFragment = new Bookmark_List();
        Bookmark_Create bookmarkCreateFragment = new Bookmark_Create();

        barAdapter.addFragments(bookmarkListFragment);
        barAdapter.addFragments(bookmarkCreateFragment);

        viewPager.setAdapter(barAdapter);
    }

}
