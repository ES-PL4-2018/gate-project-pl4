package es.gate.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import io.realm.Realm;

import java.util.HashMap;
import java.util.Objects;

public class Register_Page1 extends Fragment {

    private TextInputLayout inputUserOrcid;
    private TextInputLayout inputUserPass;
    private TextInputLayout inputUserPassConfirm;
    private Register parent;
    @SuppressLint("HandlerLeak")
    private final Handler registerPage1Handler = new Handler() {

        @Override
        public void handleMessage(Message message) {

            HashMap response = (HashMap) message.getData().getSerializable("response");
            String status;

            try {
                status = (String) Objects.requireNonNull(response).get("status");
            } catch (NullPointerException e) {
                Log.d("RegisterPage1", "Orcid response was null");
                return;
            }

            if (status.equals("Successful")) {

                response.put("orcid", Objects.requireNonNull(inputUserOrcid.getEditText()).getText().toString());
                response.put("password", Objects.requireNonNull(inputUserPass.getEditText()).getText().toString());
                parent.setInfo(response);
                parent.registerPage(1);
            } else {
                Toast.makeText(getContext(), status, Toast.LENGTH_LONG).show();
            }
        }
    };
    private View.OnClickListener nextPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String orcid;
            String pass;
            String confirmPass;

            try {
                orcid = Objects.requireNonNull(inputUserOrcid.getEditText()).getText().toString();
                pass = Objects.requireNonNull(inputUserPass.getEditText()).getText().toString();
                confirmPass = Objects.requireNonNull(inputUserPassConfirm.getEditText()).getText().toString();
            } catch (NullPointerException e) {
                Log.d("RegisterPage1", "TextInput getText returned null");
                return;
            }

            if (!Static_Functions.checkLength(orcid, 16)) {
                inputUserOrcid.setError(" ");
                Toast.makeText(getContext(), "ORCID must be 16 numbers long", Toast.LENGTH_LONG).show();
            } else {
                inputUserOrcid.setError(null);
            }

            Realm realm = Realm.getDefaultInstance();
            if (realm.where(AccountInformation.class).equalTo("orcid", orcid).findFirst() != null) {
                Toast.makeText(getContext(), "ORCID already in use", Toast.LENGTH_LONG).show();
                return;
            }
            realm.close();

            if (!Static_Functions.checkLength(pass, 0)) {
                inputUserPass.setError(" ");
                Toast.makeText(getContext(), "Please insert a password", Toast.LENGTH_LONG).show();
            } else {
                inputUserPass.setError(null);
            }

            if (!Static_Functions.checkLength(confirmPass, 0)) {
                Toast.makeText(getContext(), "Please insert password", Toast.LENGTH_LONG).show();
                inputUserPassConfirm.setError(" ");
            } else {
                inputUserPassConfirm.setError(null);
            }

            if (pass.equals(confirmPass)) {
                new Thread(new Network(orcid)).start();
            } else {
                Toast.makeText(getContext(), "Password does not match", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View registerView = inflater.inflate(R.layout.menu_register_p1, container, false);

        inputUserOrcid = registerView.findViewById(R.id.registerORCID);
        inputUserPass = registerView.findViewById(R.id.registerPass);
        inputUserPassConfirm = registerView.findViewById(R.id.registerConfirmPass);


        parent = (Register) getActivity();
        registerView.findViewById(R.id.registerNextPage1).setOnClickListener(nextPage);

        return registerView;
    }

    private class Network implements Runnable {

        String orcidInfo;

        private Network(String orcidInfo) {
            this.orcidInfo = orcidInfo;
        }

        @Override
        public void run() {


            HashMap response = Static_Functions.loginORCID(orcidInfo);

            Message message = registerPage1Handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putSerializable("response", response);
            message.setData(bundle);
            registerPage1Handler.sendMessage(message);
        }
    }

}