package es.gate;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Joao Montenegro
 * 26-09-18
 * Classe associada ao layout do feed Home
 */

public class FeedHomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_feed, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
