package es.gate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText userText;
    EditText passText;
    protected String user;
    protected String pass;
    protected int wrongPass = 0;
    private static final String tag = "myActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Insert your username and password", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.continueButton:
                userText = findViewById(R.id.username);
                passText = findViewById(R.id.password);
                user = userText.getText().toString();
                pass = passText.getText().toString();
                Log.i(tag,"User: " + user);
                Log.i(tag, "Pass: " + pass);
                Log.i(tag, "Wrong Pass: " + wrongPass);
                if(false){
                    //Right password
                }else{
                    //Wrong Password
                    wrongPass += 1;
                    if(wrongPass == 3){
                        //sugerir recuperacao
                    }
                }

        }
    }

}
