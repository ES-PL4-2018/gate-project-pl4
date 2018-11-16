package es.gate.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.R;
import io.realm.Realm;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private static final String TAG = "MenuLogin";
    private TextInputLayout loginUserInput;
    private TextInputLayout loginPassInput;
    private String userString;
    private String passString;
    private Intent openMain;
    private Intent openRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_login);


        loginUserInput = findViewById(R.id.loginUserInput);
        loginPassInput = findViewById(R.id.loginPassInput);

        openMain = new Intent(this, Main.class);
        openRegister = new Intent(this, Register.class);

        Log.i(TAG, "Startup complete");
    }

    public void OnClick(View v) {
        Log.d(TAG, "" + v.getId());
        switch (v.getId()) {
            case R.id.loginLogInButton: {
                Log.i(TAG, "Login request");

                try {
                    userString = Objects.requireNonNull(loginUserInput.getEditText()).getText().toString();
                    passString = Objects.requireNonNull(loginPassInput.getEditText()).getText().toString();
                }catch (NullPointerException e){
                    Log.d("Login", "getText was null");
                    return;
                }

                //new Thread(new serverConnect()).start();
                checkLogin();
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

    private void checkLogin(){

        Realm realm = Realm.getDefaultInstance();

        AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", userString).equalTo("password", passString).findFirst();

        realm.close();

        if(accInfo == null){
            Toast.makeText(getApplicationContext(), "Invalid username and|or password", Toast.LENGTH_LONG).show();
            return;
        }

        openMain.putExtra("curAccount", userString);
        finish();
        startActivity(openMain);
    }

}
