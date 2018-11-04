package es.gate.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import es.gate.*;

import java.util.HashMap;

public class Register_Page3 extends AppCompatActivity {

    private static final String TAG = "MenuRegister";
    private Intent openMain;
    private Intent openLogin;
    private TextInputLayout inputUserName;
    private TextInputLayout inputUserPass;
    private TextInputLayout inputUserPassConfirm;
    private boolean registerP3ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPage3();

        openMain = new Intent(this, Main.class);
        openLogin = new Intent(this, Login.class);

    }

    private Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message message) {

            switch (message.getData().getString("requestType")) {
                case "verifyP3Inputs": {
                    verifyP3Inputs();
                    break;
                }
                case "checkP3Ready": {
                    checkP3Ready();
                    break;
                }
                case "finishRegister": {
                    startActivity(openMain);
                    break;
                }
                case "printToast":{
                    Toast.makeText(getApplicationContext(), message.getData().getString("message"), Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    };

    public void registerP3OnClick(View v) {
        Log.d(TAG, "" + v.getId());

        switch (v.getId()) {
            case R.id.registerP3Back: {
                Log.i(TAG, "Page 3 back request");
                super.onBackPressed();
                break;
            }
            case R.id.registerP3Cancel: {
                Log.i(TAG, "Register cancel request");
                startActivity(openLogin);
                break;
            }
            case R.id.registerRegisterButton: {
                Log.i(TAG, "Register completion request");

                Message message = handler.obtainMessage();
                Bundle bundle  = new Bundle();
                bundle.putString("requestType", "verifyP3Inputs");
                message.setData(bundle);
                handler.sendMessage(message);
                break;
            }

        }
    }

    private void setupPage3(){

        setContentView(R.layout.menu_register_p3);

        inputUserName = findViewById(R.id.registerUserName);
        inputUserPass = findViewById(R.id.registerPass);
        inputUserPassConfirm = findViewById(R.id.registerConfirmPass);

        registerP3ready = true;
    }

    private void verifyP3Inputs() {

        String id = inputUserName.getEditText().getText().toString();
        String pass = inputUserPass.getEditText().getText().toString();
        String confirmPass = inputUserPassConfirm.getEditText().getText().toString();

        registerP3ready = true;

        if(!Static_Functions.checkLength(id, 3)){
            inputUserName.setError(" ");
            registerP3ready = false;
        }else{
            inputUserName.setError(null);
        }

        if(!Static_Functions.checkLength(pass, 3)){
            inputUserPass.setError(" ");
            registerP3ready = false;
        }else{
            inputUserPass.setError(null);
        }

        if(!Static_Functions.checkLength(confirmPass, 3)){
            inputUserPassConfirm.setError(" ");
            registerP3ready = false;
        }else{
            inputUserPassConfirm.setError(null);
        }

        if(pass.equals(confirmPass)){
            new Thread(new NetworkCommunication(Static_Functions.compileRegisterChoice("page3", id, null))).start();
        }else{
            Message message = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("requestType", "printToast");
            bundle.putString("message", "Passwords must match");
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    private void checkP3Ready(){


        if(registerP3ready){
            System.out.println("Yeeeeeeeee");
            Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();

            userInfo.setIdPass(inputUserName.getEditText().getText().toString(), inputUserPass.getEditText().getText().toString());

            new Thread(new NetworkCommunication(Static_Functions.compileRegisterChoice("finishRegister", null, userInfo.getAccount()))).start();

        }
    }


    private class NetworkCommunication implements Runnable {


        HashMap info;

        public NetworkCommunication(HashMap info) {
            this.info = info;
        }


        @Override
        public void run() {
            switch ((String) info.get("comType")) {
                case "page3": {
                    page3();
                    break;
                }
                case "finishRegister": {
                    finishRegister();
                    break;
                }
            }
        }

        private void page3() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileCheckID((String) info.get("info"));

            communication = srv.sendMessage(communication);

            System.out.println(communication);

            if ((boolean) communication.get("checkIDResult")) {
                System.out.println("ye");
                Message toast = handler.obtainMessage();
                Bundle toastBundle = new Bundle();
                toastBundle.putString("requestType", "printToast");
                toastBundle.putString("message", "Username already used");
                toast.setData(toastBundle);
                handler.sendMessage(toast);
            } else {
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("requestType", "checkP3Ready");
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }

        private void finishRegister() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileFinishRegister((User_Account) info.get("acc"));

            communication = srv.sendMessage(communication);

            System.out.println(communication);

            if ((boolean) communication.get("registerResult")) {
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("requestType", "finishRegister");
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }
    }

}
