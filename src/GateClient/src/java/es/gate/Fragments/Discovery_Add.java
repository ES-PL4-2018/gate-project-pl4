package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.gate.R;
import io.realm.Realm;

public class Discovery_Add extends Fragment {

    private View createFragment;
    private Discovery parent;
    Realm realm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        createFragment = inflater.inflate(R.layout.menu_discovery_search, container, false);

        parent = (es.gate.Fragments.Discovery)getParentFragment();


        return createFragment;
    }

    /*
    To show other menu when pressing add for example call parent.discoveryClick(0)
     */
}
