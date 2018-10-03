/*
###File created at 01/10/2018 2:47
###Created by Alexandre Brito

##Revision v0.1
#1/10/2018 2:47
#Alexandre Brito
#Initial Criation



*/

package es.gate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import es.gate.InputCheck.*;

public class RegisterP1Activity extends AppCompatActivity {

    private Intent registerPage2;
    private volatile int nextReady = 0;
    public volatile boolean nameReady;
    public volatile boolean passReady;
    public volatile boolean emailReady;
    public volatile boolean orcidReady;
    private TextInputLayout inputUserName;
    private TextInputLayout inputUserPass;
    private TextInputLayout inputUserEmail;
    private TextInputLayout inputORCID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_p1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(249, 143, 116)));
        registerPage2 = new Intent(this, RegisterP2Activity.class);

        inputUserName = findViewById(R.id.InputUserName);
        inputUserPass = findViewById(R.id.InputUserPass);
        inputUserEmail = findViewById(R.id.InputUserEmail);
        inputORCID = findViewById(R.id.InputORCID);

        nameReady = false;
        passReady = false;
        emailReady = false;
        orcidReady = false;
    }

    @Override
    protected void onStart(){

        findViewById(R.id.Page1to2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nextReady == 4) {
                    registerPage2.putExtra("user", inputUserName.getEditText().getText().toString());
                    registerPage2.putExtra("pass", inputUserPass.getEditText().getText().toString());
                    registerPage2.putExtra("mail", inputUserEmail.getEditText().getText().toString());
                    registerPage2.putExtra("orcid", inputORCID.getEditText().getText().toString());
                    startActivity(registerPage2);
                }
            }
        });

        inputUserName.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String userName = inputUserName.getEditText().getText().toString();
                boolean problem = false;
                Log.d("name", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(userName, 5)){
                        Log.d("name", "length");
                        inputUserName.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(userName)){
                        Log.d("name", "chars");
                        inputUserName.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputUserName.setError(null);
                        new Thread(new serverConnect("name", userName)).start();
                    }else{
                        if(nameReady){
                            nameReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputUserPass.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = inputUserPass.getEditText().getText().toString();
                boolean problem = false;
                Log.d("pass", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(password, 5)){
                        Log.d("pass", "length");
                        inputUserPass.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(password)){
                        Log.d("pass", "chars");
                        inputUserPass.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputUserPass.setError(null);
                        if(!passReady){
                            passReady = true;
                            Log.d("Button", "pass");
                            nextReady++;
                        }
                        checkButton();
                    }else{
                        if(passReady){
                            passReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputUserEmail.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String email = inputUserEmail.getEditText().getText().toString();
                boolean problem = false;
                Log.d("email", "focuschange");
                if(!hasFocus){

                    if(!InputCheck.stringCheckEmail(email)){
                        Log.d("email", "format");
                        inputUserEmail.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputUserEmail.setError(null);
                        new Thread(new serverConnect("email", email)).start();
                    }else{
                        if(emailReady){
                            emailReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputORCID.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String orcid = inputORCID.getEditText().getText().toString();
                boolean problem = false;
                Log.d("orcid", "focuschange");
                if(!hasFocus){

                    if(!InputCheck.stringCheckLength(orcid, 16)){
                        Log.d("orcid", "chars");
                        inputORCID.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputORCID.setError(null);
                        new Thread(new serverConnect("orcid", orcid)).start();
                    }else{
                        if(orcidReady){
                            orcidReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        super.onStart();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class serverConnect implements Runnable{

        private String request;
        private String str;

        public serverConnect(String request, String str){
            this.request = request;
            this.str = str;
        }

        @Override
        public void run() {
            ServerConnection srv = ServerConnection.getInstance();
            Log.d("threadRun", "start");

            String communication;

            switch (request){
                case "name": {
                    //name check
                    communication = String.format("!checkUser&%s", str);
                    break;
                }
                case "email":{
                    //email check
                    communication = String.format("!checkEmail&%s", str);
                    break;
                }
                case "orcid":{
                    //orcid check
                    communication = String.format("!checkOrcid&%s", str);
                    break;
                }
                default:{
                    communication = "!error";
                    break;
                }
            }

            communication = srv.sendMessage(communication);

            int response = Integer.parseInt(communication);

            switch (request){
                case "name": {
                    //name response
                    if(response == 0){
                        if(!nameReady){
                            nameReady = true;
                            nextReady++;
                            Log.d("Button", "name");
                        }
                    }else{
                        if(nameReady){
                            nameReady = false;
                            nextReady--;
                        }
                    }
                    break;
                }
                case "email":{
                    //email response
                    if(response == 0){
                        if(!emailReady){
                            emailReady = true;
                            nextReady++;
                            Log.d("Button", "email");
                        }
                    }else{
                        if(emailReady){
                            emailReady = false;
                            nextReady--;
                        }
                    }
                    break;
                }
                case "orcid":{
                    //orcid response
                    if(response == 0){
                        if(!orcidReady){
                            orcidReady = true;
                            nextReady++;
                            Log.d("Button", "orcid");
                        }
                    }else{
                        if(orcidReady){
                            orcidReady = false;
                            nextReady--;
                        }
                    }
                    break;
                }
            }
            checkButton();

        }
    }

    public void checkButton(){
        Log.d("Button", String.format("%d", nextReady));
    }



}
