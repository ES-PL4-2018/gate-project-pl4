package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import es.gate.Menus.Main;
import es.gate.R;

import java.util.Objects;

public class Discovery_Add extends Fragment {

    private Discovery parent;
    private RecyclerView recyclerView;
    private es.gate.Cards.Adapters.Discovery_Add adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View createFragment = inflater.inflate(R.layout.menu_discovery_add, container, false);

        parent = (es.gate.Fragments.Discovery) getParentFragment();

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_EVENLY);

        recyclerView = createFragment.findViewById(R.id.discoveryRecyclerView);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new es.gate.Cards.Adapters.Discovery_Add(((Main) Objects.requireNonNull(parent.getActivity())).getCurAccount(), (Discovery) getParentFragment());

        createFragment.findViewById(R.id.discoveryBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.discoveryEvent(1);
            }
        });

        return createFragment;
    }

    public void updateView() {

        adapter = new es.gate.Cards.Adapters.Discovery_Add(((Main) Objects.requireNonNull(parent.getActivity())).getCurAccount(), (Discovery) getParentFragment());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
