package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import es.gate.Cards.Adapters.Bookmark;
import es.gate.Menus.Main;
import es.gate.R;

import java.util.Objects;

public class Bookmark_List extends Fragment {

    private es.gate.Fragments.Bookmark parent;
    private Bookmark cardAdapter;
    private RecyclerView recyclerView;
    private String curAccount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View listFragment = inflater.inflate(R.layout.menu_bookmark_list, container, false);
        parent = (es.gate.Fragments.Bookmark) getParentFragment();

        curAccount = ((Main) (Objects.requireNonNull(Objects.requireNonNull(getParentFragment()).getActivity()))).getCurAccount();

        recyclerView = listFragment.findViewById(R.id.bookmarkRecyclerView);
        recyclerView.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new Bookmark(getContext(), curAccount);
        recyclerView.setAdapter(cardAdapter);

        listFragment.findViewById(R.id.bookmarkCreate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.bookmarkClick(0);
            }
        });

        return listFragment;
    }

    public void updateData() {
        try {
            cardAdapter = new Bookmark(getContext(), curAccount);
            recyclerView.setAdapter(cardAdapter);
        } catch (NullPointerException e) {
            Log.d("Bookmark_List", "cardAdapter was null");
        }
    }

}
