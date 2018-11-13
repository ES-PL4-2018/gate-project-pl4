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

/*
public class Register_Page1 extends AppCompatActivity {

    private static final String TAG = "MenuRegister";
    private TextInputLayout inputFirstName;
    private TextInputLayout inputLastName;
    private TextInputLayout inputUserEmail;
    private TextInputLayout inputInstitution;
    private TextInputLayout inputInvestigation;
    private TextInputLayout inputResearchCenter;
    private TextInputLayout inputORCID;

    private Intent openLogin;
    private Intent nextPage;
    private boolean registerP1ready;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPage1();

        openLogin = new Intent(this, Login.class);
        nextPage = new Intent(this, Register_Page2.class);
    }

    private Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message message) {
            switch(message.getData().getString("requestType")){
                case "verifyP1Inputs":{
                    verifyP1Inputs();
                    break;
                }
                case "checkP1Ready":{
                    checkP1Ready();
                    break;
                }
                case "nextPage1":{
                    finish();
                    startActivity(nextPage);
                    break;
                }
                case "validEmail":{
                    inputUserEmail.setError(null);
                    break;
                }
                case "errorEmail":{
                    inputUserEmail.setError(" ");
                    break;
                }
                case "validOrcid":{
                    inputORCID.setError(null);
                    break;
                }
                case "errorOrcid":{
                    inputORCID.setError(" ");
                    break;
                }
                case "printToast":{
                    Toast.makeText(getApplicationContext(), message.getData().getString("message"), Toast.LENGTH_LONG).show();
                    findViewById(R.id.registerNextPage1).setClickable(true);
                    break;
                }
            }
            super.handleMessage(message);
        }
    };

    private TextWatcher inputFirstNameWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            System.out.println(s.length());
            if(s.length() == 0){
                inputFirstName.setError(" ");
            }else{
                inputFirstName.setError(null);
            }
        }
    };

    private TextWatcher inputLastNameWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() == 0){
                inputLastName.setError(" ");
            }else{
                inputLastName.setError(null);
            }
        }
    };

    private TextWatcher inputInstitutionWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() == 0){
                inputInstitution.setError(" ");
            }else{
                inputInstitution.setError(null);
            }
        }
    };

    private TextWatcher inputInvestigationWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() == 0){
                inputInvestigation.setError(" ");
            }else{
                inputInvestigation.setError(null);
            }
        }
    };

    private TextWatcher inputResearchWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() == 0){
                inputResearchCenter.setError(" ");
            }else{
                inputResearchCenter.setError(null);
            }
        }
    };

    private void setupPage1(){

        setContentView(R.layout.menu_register_p2);

        inputFirstName = findViewById(R.id.registerFirstNameInput);
        inputLastName = findViewById(R.id.registerLastNameInput);
        inputUserEmail = findViewById(R.id.registerEmailInput);
        inputInstitution = findViewById(R.id.registerInstitutionInput);
        inputInvestigation = findViewById(R.id.registerInvestigationInput);
        inputResearchCenter = findViewById(R.id.registerResearchCenter);
        inputORCID = findViewById(R.id.registerORCIDInput);

        inputFirstName.getEditText().addTextChangedListener(inputFirstNameWatcher);
        inputLastName.getEditText().addTextChangedListener(inputLastNameWatcher);
        inputInstitution.getEditText().addTextChangedListener(inputInstitutionWatcher);
        inputInvestigation.getEditText().addTextChangedListener(inputInvestigationWatcher);
        inputResearchCenter.getEditText().addTextChangedListener(inputResearchWatcher);

        registerP1ready = true;
    }

    private void verifyP1Inputs() {

        registerP1ready = true;

        if(!Static_Functions.checkLength(inputFirstName.getEditText().getText().toString(), 0)){
            inputFirstName.setError(" ");
            registerP1ready = false;
        }
        if(!Static_Functions.checkLength(inputLastName.getEditText().getText().toString(), 0)){
            inputLastName.setError(" ");
            registerP1ready = false;
        }
        if(!Static_Functions.checkLength(inputInstitution.getEditText().getText().toString(), 0)){
            inputInstitution.setError(" ");
            registerP1ready = false;
        }
        if(!Static_Functions.checkLength(inputInvestigation.getEditText().getText().toString(), 0)){
            inputInvestigation.setError(" ");
            registerP1ready = false;
        }
        if(!Static_Functions.checkLength(inputResearchCenter.getEditText().getText().toString(), 0)){
            inputResearchCenter.setError(" ");
            registerP1ready = false;
        }

        new Thread(new NetworkCommunication(Static_Functions.compileRegisterChoice("page1", inputUserEmail.getEditText().getText().toString(), null))).start();
    }

    private void checkP1Ready(){

        if(registerP1ready){

            Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();
            User_Account newAcc = new User_Account();

            newAcc.setFirstName(inputFirstName.getEditText().getText().toString());
            newAcc.setLastName(inputLastName.getEditText().getText().toString());
            newAcc.setUserEmail(inputUserEmail.getEditText().getText().toString());
            newAcc.setInstitution(inputInstitution.getEditText().getText().toString());
            newAcc.setInvestigation(inputInvestigation.getEditText().getText().toString());
            newAcc.setInvestigationUnits(inputResearchCenter.getEditText().getText().toString());
            newAcc.setUserORCID(Long.parseLong(inputORCID.getEditText().getText().toString()));

            userInfo.setAccount(newAcc);

            Message message = handler.obtainMessage();
            Bundle bundle  = new Bundle();
            bundle.putString("requestType", "nextPage1");
            message.setData(bundle);
            handler.sendMessage(message);

            return;
        }
        findViewById(R.id.registerNextPage1).setClickable(true);
    }

    public void registerP1OnClick(View v) {
        Log.d(TAG, "" + v.getId());

        switch (v.getId()) {
            case R.id.registerP1Back: { //TODO Change name frontend
                Log.i(TAG, "Page 1 back request");
                super.onBackPressed();
                break;
            }
            case R.id.registerP1Cancel: {
                Log.i(TAG, "Register cancel request");
                onBackPressed();
                break;
            }
            case R.id.registerNextPage1: {
                Log.i(TAG, "Page 1 next page request");

                findViewById(R.id.registerNextPage1).setClickable(false);

                Message message = handler.obtainMessage();
                Bundle bundle  = new Bundle();
                bundle.putString("requestType", "verifyP1Inputs");
                message.setData(bundle);
                handler.sendMessage(message);

                break;
            }
        }
    }

    private class NetworkCommunication implements Runnable{

        HashMap info;

        public NetworkCommunication(HashMap info){
            this.info = info;
        }

        @Override
        public void run() {

            Message emailMessage = handler.obtainMessage();
            Bundle emailBundle  = new Bundle();

            String toastMessage = "";

            if (!Static_Functions.checkEmail(inputUserEmail.getEditText().getText().toString())){
                registerP1ready = false;
                emailBundle.putString("requestType", "errorEmail");
                emailMessage.setData(emailBundle);
                handler.sendMessage(emailMessage);
                toastMessage = toastMessage.concat("Invalid e-mail address");
            }else if(checkEmail()){
                registerP1ready = false;
                emailBundle.putString("requestType", "errorEmail");
                emailMessage.setData(emailBundle);
                handler.sendMessage(emailMessage);
                toastMessage = toastMessage.concat("E-mail already in use");
            }else{
                emailBundle.putString("requestType", "validEmail");
                emailMessage.setData(emailBundle);
                handler.sendMessage(emailMessage);
            }

            Message orcidMessage = handler.obtainMessage();
            Bundle orcidBundle  = new Bundle();

            if(!Static_Functions.checkORCID(inputORCID.getEditText().getText().toString())){
                registerP1ready = false;
                orcidBundle.putString("requestType", "errorOrcid");
                orcidMessage.setData(orcidBundle);
                handler.sendMessage(orcidMessage);
                if(toastMessage.length() > 0){
                    toastMessage = toastMessage.concat("\n");
                }
                toastMessage = toastMessage.concat("Invalid ORCID");
            }else{
                orcidBundle.putString("requestType", "validOrcid");
                orcidMessage.setData(orcidBundle);
                handler.sendMessage(orcidMessage);
            }

            if(toastMessage.length() > 0){
                Message toast = handler.obtainMessage();
                Bundle toastBundle = new Bundle();
                toastBundle.putString("requestType", "printToast");
                toastBundle.putString("message", toastMessage);
                toast.setData(toastBundle);
                handler.sendMessage(toast);
            }else{
                Message message = handler.obtainMessage();
                Bundle bundle  = new Bundle();
                bundle.putString("requestType", "checkP1Ready");
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }

        private boolean checkEmail(){

            Log.d(TAG, "Thread starting");

            Singleton_ServerConnection singletonServer = Singleton_ServerConnection.getInstance();

            HashMap communication = Static_Functions.compileCheckEmail((String)info.get("info"));

            communication = singletonServer.sendMessage(communication);


            return (boolean)communication.get("checkEmailResult");
        }


    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(openLogin);
        super.onBackPressed();
    }
}

*/

public class Register_Page1 extends Fragment {

    private TextInputLayout inputUserOrcid;
    private TextInputLayout inputUserPass;
    private TextInputLayout inputUserPassConfirm;
    private Register parent;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View registerView = inflater.inflate(R.layout.menu_register_p1, container, false);

        inputUserOrcid = registerView.findViewById(R.id.registerORCID);
        inputUserPass = registerView.findViewById(R.id.registerPass);
        inputUserPassConfirm = registerView.findViewById(R.id.registerConfirmPass);


        parent = (Register)getActivity();
        registerView.findViewById(R.id.registerNextPage1).setOnClickListener(nextPage);

        return registerView;
    }

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

            if(status.equals("Successful")){

                response.put("orcid", Objects.requireNonNull(inputUserOrcid.getEditText()).getText().toString());
                response.put("password", Objects.requireNonNull(inputUserPass.getEditText()).getText().toString());
                parent.setInfo(response);
                parent.registerPage(1);
            }else{
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
            }catch(NullPointerException e){
                Log.d("RegisterPage1", "TextInput getText returned null");
                return;
            }

            if(!Static_Functions.checkLength(orcid, 16)){
                inputUserOrcid.setError(" ");
                Toast.makeText(getContext(), "ORCID must be 16 numbers long", Toast.LENGTH_LONG).show();
            }else{
                inputUserOrcid.setError(null);
            }

            Realm realm = Realm.getDefaultInstance();
            if(realm.where(AccountInformation.class).equalTo("orcid", orcid).findFirst() != null){
                Toast.makeText(getContext(), "ORCID already in use", Toast.LENGTH_LONG).show();
                return;
            }
            realm.close();

            if(!Static_Functions.checkLength(pass, 0)){
                inputUserPass.setError(" ");
                Toast.makeText(getContext(), "Please insert a password", Toast.LENGTH_LONG).show();
            }else{
                inputUserPass.setError(null);
            }

            if(!Static_Functions.checkLength(confirmPass, 0)){
                Toast.makeText(getContext(), "Please insert password", Toast.LENGTH_LONG).show();
                inputUserPassConfirm.setError(" ");
            }else{
                inputUserPassConfirm.setError(null);
            }

            if(pass.equals(confirmPass)){
                new Thread(new Network(orcid)).start();
            }else{
                Toast.makeText(getContext(), "Password does not match", Toast.LENGTH_LONG).show();
            }
        }
    };


    private class Network implements Runnable{

        String orcidInfo;

        private Network(String orcidInfo){
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