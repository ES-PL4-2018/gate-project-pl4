package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.Bookmarks;
import es.gate.R;
import es.gate.Static_Functions;
import io.realm.Realm;
import io.realm.RealmList;

public class Discovery_Contact extends Fragment {

    private View createFragment;
    private Discovery parent;
    Realm realm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        createFragment = inflater.inflate(R.layout.menu_discovery_list, container, false);

        parent = (es.gate.Fragments.Discovery)getParentFragment();


        return createFragment;
    }

    /*
    To show other menu when pressing add for example call parent.discoveryClick(1)
     */
}