package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import es.gate.*;
import es.gate.Cards.Bookmark;

import java.util.HashMap;

public class Bookmark_Create extends Fragment {

    private View createFragment;
    private EditText name;
    private EditText link;
    private EditText tags;
    es.gate.Fragments.Bookmark parent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        createFragment = inflater.inflate(R.layout.menu_bookmark_create, container, false);

        name = createFragment.findViewById(R.id.createBookmarkNameImput);
        link = createFragment.findViewById(R.id.createBookmarkLinkInput);
        tags = createFragment.findViewById(R.id.createBookmarkTagsInput);

        parent = (es.gate.Fragments.Bookmark) getParentFragment();

        createFragment.findViewById(R.id.createBookmarkConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkInputs()){
                    Singleton_UserInformation.getInstance().getAccount().addUserBookmarks(new Bookmark(tags.getText().toString(), name.getText().toString(), link.getText().toString()));
                    new Thread(new serverConnect()).start();
                    tags.setText("");
                    name.setText("");
                    link.setText("");
                    parent.bookmarkClick(1);
                }else{
                    Toast.makeText(getContext(), "All fields must have at least three chars", Toast.LENGTH_LONG).show();
                }
                //TODO add bookmark

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

    private boolean checkInputs(){

        if(Static_Functions.checkLength(name.getText().toString(), 0)){
            if(Static_Functions.checkLength(link.getText().toString(), 0)){
                if(Static_Functions.checkLength(tags.getText().toString(), 0)){
                    return true;
                }
            }
        }
        return false;
    }

    class serverConnect implements Runnable {

        private static final String TAG = "Menu_LoginThread";

        @Override
        public void run() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Singleton_UserInformation info = Singleton_UserInformation.getInstance();

            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileUserWrite(info.getAccount());

            communication = srv.sendMessage(communication);

            System.out.println(communication.get("writeResult"));
        }
    }
}
