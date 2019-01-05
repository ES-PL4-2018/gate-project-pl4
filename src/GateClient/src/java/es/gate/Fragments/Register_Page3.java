package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import es.gate.Cards.Interests;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Register;
import es.gate.R;
import io.realm.RealmList;

import java.util.ArrayList;
import java.util.Objects;

public class Register_Page3 extends Fragment {

    private View registerView;
    private AccountInformation accInfo;
    private es.gate.Cards.Adapters.Register cardAdapter;
    private TextInputLayout inputInterestsSearch;
    private ArrayList<Interests> allInterests;
    private ArrayList<Interests> curInterests;
    private Register parent;
    private TextWatcher inputInterestsSearchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == 0) {
                curInterests.clear();
                curInterests.addAll(allInterests);
                cardAdapter.notifyDataSetChanged();
                return;
            }

            if (before < count) { //more precise search
                for (int i = 0; i < curInterests.size(); i++) {
                    if (!curInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase())) {
                        curInterests.remove(i);
                        cardAdapter.notifyItemRemoved(i);
                        i--;
                    }
                }

            } else { //less precise search
                for (int i = 0; i < allInterests.size(); i++) {
                    if (allInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase()) && !curInterests.contains(allInterests.get(i))) {
                        int j = 0;
                        for (Interests inter : allInterests) {
                            if (inter.equals(allInterests.get(i)))
                                break;
                            if (curInterests.contains(inter))
                                j++;
                        }
                        curInterests.add(j, allInterests.get(i));
                        cardAdapter.notifyItemInserted(i);
                        i--;
                    }
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private View.OnClickListener addInterest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Objects.requireNonNull(inputInterestsSearch.getEditText()).getText().length() > 0) {
                try {
                    allInterests.add(new Interests(Objects.requireNonNull(inputInterestsSearch.getEditText()).getText().toString()));
                    allInterests.get(allInterests.size() - 1).setSelected();
                    curInterests.add(allInterests.get(allInterests.size() - 1));
                    cardAdapter.notifyItemInserted(allInterests.size() - 1);
                } catch (NullPointerException e) {
                    Log.d("RegisterPage3", "getEditText adding was null");
                }
            }
        }
    };
    private View.OnClickListener finishRegister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = 0;

            RealmList<String> interests = new RealmList<>();

            for (Interests inter : curInterests) {

                if (inter.isSelected()) {
                    interests.add(inter.getInterest());
                    i++;
                }
            }

            if (i > 2) {
                accInfo.setInterests(interests);
                parent.registerPage(3);
            } else {
                Toast.makeText(getContext(), "Please select at least 3 interests", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        registerView = inflater.inflate(R.layout.menu_register_p3, container, false);
        parent = (es.gate.Menus.Register) getActivity();

        assert parent != null;
        accInfo = parent.getInfo();

        registerView.findViewById(R.id.registerRegisterButton).setOnClickListener(finishRegister);
        registerView.findViewById(R.id.registerAddInterest).setOnClickListener(addInterest);

        setupPage();

        return registerView;
    }

    private void setupPage() {


        inputInterestsSearch = registerView.findViewById(R.id.registerReshSearch);

        try {
            Objects.requireNonNull(inputInterestsSearch.getEditText()).addTextChangedListener(inputInterestsSearchWatcher);
        } catch (NullPointerException e) {
            Log.d("RegisterPage3", "getEditText was null");
        }

        allInterests = new ArrayList<>();
        curInterests = new ArrayList<>();
        addInterests();
        curInterests.addAll(allInterests);
        RecyclerView recyclerView = registerView.findViewById(R.id.registerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cardAdapter = new es.gate.Cards.Adapters.Register(curInterests);
        recyclerView.setAdapter(cardAdapter);
    }

    private void addInterests() {

        allInterests.add(new Interests("Informatics"));
        allInterests.add(new Interests("Medicine"));
        allInterests.add(new Interests("Biology"));
        allInterests.add(new Interests("Physics"));
        allInterests.add(new Interests("Astronomy"));
        allInterests.add(new Interests("Chemistry"));
        allInterests.add(new Interests("Mathematics"));
        allInterests.add(new Interests("Geology"));
        allInterests.add(new Interests("Systems Theory"));
        allInterests.add(new Interests("Computer Science"));
        allInterests.add(new Interests("Engineering"));
    }
}

