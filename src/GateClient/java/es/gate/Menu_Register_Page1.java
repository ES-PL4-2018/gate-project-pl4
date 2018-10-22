package es.gate;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

public class Menu_Register_Page1 extends AppCompatActivity {

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

        openLogin = new Intent(this, Menu_Login.class);
        nextPage = new Intent(this, Menu_Register_Page2.class);
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
            if(s.length() < 3){
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
            if(s.length() < 3){
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
            if(s.length() < 3){
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
            if(s.length() < 3){
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
            if(s.length() < 3){
                inputResearchCenter.setError(" ");
            }else{
                inputResearchCenter.setError(null);
            }
        }
    };

    private void setupPage1(){

        setContentView(R.layout.menu_register_p1);

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

        if(!Static_InputCheck.checkLength(inputFirstName.getEditText().getText().toString(), 3)){
            inputFirstName.setError(" ");
            registerP1ready = false;
        }
        if(!Static_InputCheck.checkLength(inputLastName.getEditText().getText().toString(), 3)){
            inputLastName.setError(" ");
            registerP1ready = false;
        }
        if(!Static_InputCheck.checkLength(inputInstitution.getEditText().getText().toString(), 3)){
            inputInstitution.setError(" ");
            registerP1ready = false;
        }
        if(!Static_InputCheck.checkLength(inputInvestigation.getEditText().getText().toString(), 3)){
            inputInvestigation.setError(" ");
            registerP1ready = false;
        }
        if(!Static_InputCheck.checkLength(inputResearchCenter.getEditText().getText().toString(), 3)){
            inputResearchCenter.setError(" ");
            registerP1ready = false;
        }

        new Thread(new NetworkCommunication(Static_HashCompiler.compileRegisterChoice("page1", inputUserEmail.getEditText().getText().toString(), null))).start();
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
            newAcc.setResearchUnits(inputResearchCenter.getEditText().getText().toString());
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
                startActivity(openLogin);
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

            if (!Static_InputCheck.checkEmail(inputUserEmail.getEditText().getText().toString())){
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

            if(!Static_InputCheck.checkORCID(inputORCID.getEditText().getText().toString())){
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

            HashMap communication = Static_HashCompiler.compileCheckEmail((String)info.get("info"));

            communication = singletonServer.sendMessage(communication);


            return (boolean)communication.get("checkEmailResult");
        }


    }
}
