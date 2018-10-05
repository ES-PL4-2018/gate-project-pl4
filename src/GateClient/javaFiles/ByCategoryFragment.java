package es.gate;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

/**
 * Joao Montenegro
 * 28/09/18
 * Fragmento que contem a lista de categorias no TabLayout.
 */

public class ByCategoryFragment extends Fragment implements Serializable{

    View thisView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_feed, container, false);
        super.onCreateView(inflater, container, savedInstanceState);

        thisView = view;

        return view;
    }

    public View getView(){
        return thisView;
    }
}
