package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.gate.Menus.Main;
import es.gate.R;

import java.util.Objects;

public class Discovery_List extends Fragment {

    private Discovery parent;
    private es.gate.Cards.Adapters.Discovery_List adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View createFragment = inflater.inflate(R.layout.menu_discovery_list, container, false);

        parent = (es.gate.Fragments.Discovery) getParentFragment();

        LinearLayoutManager layout = new LinearLayoutManager(getContext());

        recyclerView = createFragment.findViewById(R.id.discoveryRecyclerView);
        recyclerView.setLayoutManager(layout);
        adapter = new es.gate.Cards.Adapters.Discovery_List(((Main) Objects.requireNonNull(parent.getActivity())).getCurAccount(), (Discovery) getParentFragment());
        recyclerView.setAdapter(adapter);

        createFragment.findViewById(R.id.discoveryAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.discoveryEvent(2);
            }
        });
        return createFragment;
    }

    public void updateView() {

        adapter = new es.gate.Cards.Adapters.Discovery_List(((Main) Objects.requireNonNull(parent.getActivity())).getCurAccount(), (Discovery) getParentFragment());
        recyclerView.setAdapter(adapter);
    }
}