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
import es.gate.DatabaseClasses.UsersContacts;
import es.gate.Discover.DiscoverContacts;
import io.realm.Realm;
import io.realm.exceptions.RealmMigrationNeededException;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

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
        /*
        //Teste obter contacts + realm
        Realm.init(this);

        // Multicast tem de ser numa thread porque android nao permite usar sockets na thread principal
        new Thread(new Runnable() {
            @Override
            public void run() {
                Realm realm;
                // Reset realm para nao acumular dados dos testes anteriores
                Realm.deleteRealm(Realm.getDefaultConfiguration());
                try {
                    realm = Realm.getDefaultInstance();
                } catch (RealmMigrationNeededException e){
                    System.out.println(e);
                    Realm.deleteRealm(Realm.getDefaultConfiguration());
                    realm = Realm.getDefaultInstance();
                }
                int size = 10;
                User_Account[] users = new User_Account[size];
                for (int i = 0; i < size; i++){
                    users[i] = new User_Account();
                    users[i].setUserORCID((long)i);
                }
                UsersContacts[] contacts = new UsersContacts[size * 3];
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < 3; j++){
                        contacts[i*3 + j] = new UsersContacts(users[i], users[ThreadLocalRandom.current().nextInt(0, 9)]);
                        realm.beginTransaction();
                        realm.copyToRealm(contacts[i*3+j]);
                        realm.commitTransaction();
                    }
                }
                DiscoverContacts[] dc = new DiscoverContacts[size];
                for (int i = 0; i < size; i++){
                    dc[i] = new DiscoverContacts(users[i]);
                }
                for (int i = 0; i < size; i++) {
                    dc[0].requestContacts(users[i].getUserORCID());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e){
                        System.out.println("Sleep ex " + e);
                    }
                }
            }
        }).start();
*/
        
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
