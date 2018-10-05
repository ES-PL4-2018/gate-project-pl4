package es.gate;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Joao Montenegro
 * 26-09-18
 * Fragmento que contem a lista de publicações no TabLayout
 */

public class FeedHomeFragment extends Fragment implements Serializable {

    private View thisView;

    private static final String TAG = "MyActivity";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.content_feed, container, false);

        thisView = view;
        return view;
    }

    public View getView(){
        return thisView;
    }

}
