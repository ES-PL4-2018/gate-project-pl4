package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Register;
import es.gate.R;
import es.gate.Static_Functions;

import java.util.Objects;

public class Register_Page2 extends Fragment {

    private Register parent;
    private View registerView;
    private AccountInformation accInfo;
    private TextInputLayout inputFirstName;
    private TextInputLayout inputLastName;
    private TextInputLayout inputUserEmail;
    private TextInputLayout inputInstitution;
    private TextInputLayout inputInvestigation;
    private View.OnClickListener nextPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            boolean validInfo = true;


            try {
                if (!Static_Functions.checkLength(Objects.requireNonNull(inputFirstName.getEditText()).getText().toString(), 0)) {
                    inputFirstName.setError(" ");
                    validInfo = false;
                }
            } catch (NullPointerException e) {
                Log.d("RegisterPage2", "First Name getText was null");
            }
            try {
                if (!Static_Functions.checkLength(Objects.requireNonNull(inputLastName.getEditText()).getText().toString(), 0)) {
                    inputLastName.setError(" ");
                    validInfo = false;
                }
            } catch (NullPointerException e) {
                Log.d("RegisterPage2", "Last Name getText was null");
            }
            try {
                if (!Static_Functions.checkEmail(Objects.requireNonNull(inputUserEmail.getEditText()).getText().toString())) {
                    inputUserEmail.setError(" ");
                    validInfo = false;
                }
            } catch (NullPointerException e) {
                Log.d("RegisterPage2", "Email getText was null");
            }
            try {
                if (!Static_Functions.checkLength(Objects.requireNonNull(inputInstitution.getEditText()).getText().toString(), 0)) {
                    inputInstitution.setError(" ");
                    validInfo = false;
                }
            } catch (NullPointerException e) {
                Log.d("RegisterPage2", "Institution getText was null");
            }
            try {
                if (!Static_Functions.checkLength(Objects.requireNonNull(inputInvestigation.getEditText()).getText().toString(), 0)) {
                    inputInvestigation.setError(" ");
                    validInfo = false;
                }
            } catch (NullPointerException e) {
                Log.d("RegisterPage2", "Investigation getText was null");
            }

            if (!validInfo) {

                Toast.makeText(getContext(), "Please verify your personal information", Toast.LENGTH_LONG).show();
            } else {
                updateInfo();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        registerView = inflater.inflate(R.layout.menu_register_p2, container, false);
        parent = (es.gate.Menus.Register) getActivity();

        try {
            accInfo = Objects.requireNonNull(parent).getInfo();
        } catch (NullPointerException e) {
            Log.d("RegisterPage2", "Parent was null");
        }

        inputSetup();

        registerView.findViewById(R.id.registerNextPage2).setOnClickListener(nextPage);

        return registerView;
    }

    public void inputSetup() {

        inputFirstName = registerView.findViewById(R.id.registerFirstNameInput);
        inputLastName = registerView.findViewById(R.id.registerLastNameInput);
        inputUserEmail = registerView.findViewById(R.id.registerEmailInput);
        inputInstitution = registerView.findViewById(R.id.registerInstitutionInput);
        inputInvestigation = registerView.findViewById(R.id.registerInvestigationInput);

        try {
            Objects.requireNonNull(inputFirstName.getEditText()).setText(accInfo.getUserFirstName());
            Objects.requireNonNull(inputLastName.getEditText()).setText(accInfo.getUserLastName());
            if (!accInfo.getUserEmail().equals("[]")) {
                Objects.requireNonNull(inputUserEmail.getEditText()).setText(accInfo.getUserEmail());
            }
            Objects.requireNonNull(inputInstitution.getEditText()).setText(accInfo.getInstitution());
            Objects.requireNonNull(inputInvestigation.getEditText()).setText(accInfo.getInvestigationUnits());
        } catch (NullPointerException e) {
            Log.d("RegisterPage2", "TextInput getText returned null when setting info");
        }
    }

    private void updateInfo() {

        try {
            accInfo.setUserFirstName(Objects.requireNonNull(inputFirstName.getEditText()).getText().toString());
            accInfo.setUserLastName(Objects.requireNonNull(inputLastName.getEditText()).getText().toString());
            accInfo.setUserEmail(Objects.requireNonNull(inputUserEmail.getEditText()).getText().toString());
            accInfo.setInstitution(Objects.requireNonNull(inputInstitution.getEditText()).getText().toString());
            accInfo.setInvestigationUnits(Objects.requireNonNull(inputInvestigation.getEditText()).getText().toString());
        } catch (NullPointerException e) {
            Log.d("RegisterPage2", "TextInput getText returned null when updatting info");
            Toast.makeText(getContext(), "Error updating info", Toast.LENGTH_LONG).show();
            return;
        }

        parent.registerPage(2);
    }
}