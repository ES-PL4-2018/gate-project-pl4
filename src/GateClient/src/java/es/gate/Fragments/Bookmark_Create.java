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
import es.gate.Menus.Main;
import es.gate.R;
import es.gate.Static_Functions;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.Objects;

public class Bookmark_Create extends Fragment {

    private Bookmark parent;
    private EditText name;
    private EditText link;
    private EditText tags;
    private Realm realm;
    private String curAccount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View createFragment = inflater.inflate(R.layout.menu_bookmark_create, container, false);

        name = createFragment.findViewById(R.id.createBookmarkNameImput);
        link = createFragment.findViewById(R.id.createBookmarkLinkInput);
        tags = createFragment.findViewById(R.id.createBookmarkTagsInput);

        parent = (es.gate.Fragments.Bookmark) getParentFragment();

        assert parent != null;
        curAccount = ((Main) Objects.requireNonNull(parent.getActivity())).getCurAccount();

        createFragment.findViewById(R.id.createBookmarkConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm = Realm.getDefaultInstance();

                AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();
                realm.beginTransaction();
                assert accInfo != null;
                RealmList<Bookmarks> bookmarks = accInfo.getUserBookmark();
                Bookmarks newBookmark = new Bookmarks();
                newBookmark.setBmName(name.getText().toString());
                newBookmark.setBmTags(tags.getText().toString());
                newBookmark.setBmUrl(link.getText().toString());
                bookmarks.add(newBookmark);
                accInfo.setUserBookmark(bookmarks);
                realm.commitTransaction();
                if (checkInputs()) {
                    tags.setText("");
                    name.setText("");
                    link.setText("");
                    parent.bookmarkClick(1);
                } else {
                    Toast.makeText(getContext(), "Please fill up all fields", Toast.LENGTH_LONG).show();
                }
                realm.close();

            }
        });

        createFragment.findViewById(R.id.createBookmarkCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parent.bookmarkClick(-1);
            }
        });

        return createFragment;
    }

    private boolean checkInputs() {

        if (Static_Functions.checkLength(name.getText().toString(), 0)) {
            if (Static_Functions.checkLength(link.getText().toString(), 0)) {
                if (Static_Functions.checkLength(tags.getText().toString(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
