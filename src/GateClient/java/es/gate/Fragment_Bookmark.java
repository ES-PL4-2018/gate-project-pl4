package es.gate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Bookmark extends Fragment {

    private Menu_Main parent;
    private View bookmarkView;
    private Fragment_Bookmark_Create bookmarkCreateFragment;
    private Fragment_Bookmark_List bookmarkListFragment;
    private ViewPager viewPager;
    private BVN_BottomBarAdapter barAdapter;
    private Card_Bookmark_Adapter cardAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        bookmarkView = inflater.inflate(R.layout.menu_bookmark, container, false);

        parent = (Menu_Main) getActivity();

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

        barAdapter = new BVN_BottomBarAdapter(getChildFragmentManager());
        viewPager = bookmarkView.findViewById(R.id.bookmarkViewPager);


        bookmarkListFragment = new Fragment_Bookmark_List();
        bookmarkCreateFragment = new Fragment_Bookmark_Create();

        barAdapter.addFragments(bookmarkListFragment);
        barAdapter.addFragments(bookmarkCreateFragment);

        viewPager.setAdapter(barAdapter);

    }
}
