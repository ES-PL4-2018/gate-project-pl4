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

public class Login extends AppCompatActivity {

    private static final String TAG = "MenuLogin";
    private TextInputLayout loginUserInput;
    private TextInputLayout loginPassInput;
    private String userString;
    private String passString;
    private Intent openMain;
    private Intent openRegister;
    private Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), msg.getData().getString("loginResult"), Toast.LENGTH_LONG).show();
            super.handleMessage(msg);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_login);


        loginUserInput = findViewById(R.id.loginUserInput);
        loginPassInput = findViewById(R.id.loginPassInput);

        openMain = new Intent(this, Main.class);
        openRegister = new Intent(this, Register_Page1.class);

        Log.i(TAG, "Startup complete");
    }

    public void loginOnClick(View v) {
        Log.d(TAG, "" + v.getId());
        switch (v.getId()) {
            case R.id.loginLogInButton: { //TODO Change name frontend
                Log.i(TAG, "Login request");

                userString = loginUserInput.getEditText().getText().toString();
                passString = loginPassInput.getEditText().getText().toString();


                Log.i(TAG, "User " + userString);
                Log.i(TAG, "Pass " + passString);

                /*
                Log.i(TAG, "Wrong Pass: " + wrongPass);
                if (false) { //TODO work on recover pass
                    //Right password
                } else {
                    //Wrong Password
                    wrongPass += 1;
                    if (wrongPass == 3) {
                        //sugerir recuperacao
                    }
                }
                */
                new Thread(new serverConnect()).start();
                break;
            }
            case R.id.loginRegisterButton: {
                Log.i(TAG, "Register request");
                finish();
                startActivity(openRegister);
                break;
            }
        }
    }

    class serverConnect implements Runnable {

        private static final String TAG = "Menu_LoginThread";

        @Override
        public void run() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileLogin(userString, passString);

            communication = srv.sendMessage(communication);

            String loginResult = (String)communication.get("loginResult");

            if (loginResult.equals("granted")) {

                Singleton_UserInformation inter = Singleton_UserInformation.getInstance();

                inter.setAccount((User_Account)communication.get("accountInfo"));

                finish();
                startActivity(openMain);
            }else{
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("loginResult", loginResult);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }
    }
}
