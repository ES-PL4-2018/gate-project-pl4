package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import es.gate.DatabaseClasses.UsersConnected;
import es.gate.R;
import es.gate.Static_Functions;
import io.realm.Realm;

import java.util.Objects;

public class Discovery_Profile extends Fragment {

    private Discovery parent;
    private TextView userOrcid;
    private EditText inputName;
    private EditText inputInstitution;
    private EditText inputInvestigation;
    private EditText inputEmail;
    private EditText inputLastSeen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View createFragment = inflater.inflate(R.layout.menu_discovery_profile, container, false);

        userOrcid = createFragment.findViewById(R.id.discoveryName);
        inputName = createFragment.findViewById(R.id.discoveryUserNameInput);
        inputInstitution = createFragment.findViewById(R.id.discoveryInstitutionInput);
        inputInvestigation = createFragment.findViewById(R.id.discoveryResearchUnitInput);
        inputEmail = createFragment.findViewById(R.id.discoveryUserEmailInput);
        inputLastSeen = createFragment.findViewById(R.id.discoveryLastSeenInput);

        parent = (es.gate.Fragments.Discovery) getParentFragment();

        createFragment.findViewById(R.id.discoveryRightImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.discoveryEvent(1);
            }
        });

        return createFragment;
    }

    public void updateInfo(String accountOrcid) {

        Realm realm = Realm.getDefaultInstance();

        UsersConnected user = realm.where(UsersConnected.class).equalTo("userORCID", Long.parseLong(accountOrcid)).findFirst();

        userOrcid.setText(Static_Functions.formatORCID(String.valueOf(Objects.requireNonNull(user).getUserORCID())));
        inputName.setText(user.getUserName());
        inputInstitution.setText(user.getInstitution());
        inputInvestigation.setText(user.getResearchUnits());
        inputEmail.setText(user.getUserEmail());
        inputLastSeen.setText(user.getLastSeen().toString());
    }
}
