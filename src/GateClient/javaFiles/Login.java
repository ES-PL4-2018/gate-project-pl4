package es.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private static final String tag = "myActivity";
    protected String user;
    protected String pass;
    protected int wrongPass = 0;
    EditText userText;
    EditText passText;
    private Intent goFeed;
    private Intent register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        goFeed = new Intent(this, Feed.class);
        register = new Intent(this, RegisterP1Activity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Insert your username and password", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "test");
                startActivity(register);
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continueButton: {
                userText = findViewById(R.id.username);
                passText = findViewById(R.id.password);
                user = userText.getText().toString();
                pass = passText.getText().toString();
                Log.i(tag, "User: " + user);
                Log.i(tag, "Pass: " + pass);
                Log.i(tag, "Wrong Pass: " + wrongPass);
                if (false) {
                    //Right password
                } else {
                    //Wrong Password
                    wrongPass += 1;
                    if (wrongPass == 3) {
                        //sugerir recuperacao
                    }
                }
                new Thread(new serverConnect()).start();
                break;
            }
            case R.id.registerButton: {

                break;
            }
        }
    }

    class serverConnect implements Runnable {

        @Override
        public void run() {

            ServerConnection srv = ServerConnection.getInstance();
            Log.d("threadRun", "start");

            String communication = String.format("!login&%s&%s", user, pass);

            communication = srv.sendMessage(communication);

            if (communication.equals("1")) {
                startActivity(goFeed);
            }

        }
    }
}
