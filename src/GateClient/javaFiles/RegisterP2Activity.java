/*
###File created at 01/10/2018 3:25
###Created by Alexandre Brito

##Revision v0.1
#1/10/2018 3:25
#Alexandre Brito
#Initial Criation



*/
package es.gate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class RegisterP2Activity extends AppCompatActivity {

    private Intent registerPage3;
    private volatile int nextReady = 0;
    public volatile boolean fNameReady;
    public volatile boolean lNameReady;
    public volatile boolean birthDateReady;
    public volatile boolean institReady;
    public volatile boolean rUnitsReady;
    private TextInputLayout inputFirstName;
    private TextInputLayout inputLastName;
    private TextInputLayout inputBirthDate;
    private TextInputLayout inputInstitution;
    private TextInputLayout inputRUnits;
    private String accInfo[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_p2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(249, 143, 116)));
        registerPage3 = new Intent(this, RegisterP3Activity.class);

        inputFirstName = findViewById(R.id.InputFirstName);
        inputLastName = findViewById(R.id.InputLastName);
        inputBirthDate= findViewById(R.id.InputBirth);
        inputInstitution = findViewById(R.id.InputInst);
        inputRUnits = findViewById(R.id.InputResearch);

        fNameReady = false;
        lNameReady = false;
        birthDateReady = false;
        institReady = false;
        rUnitsReady = false;

    }

    @Override
    protected void onStart(){

        accInfo = new String[4];
        accInfo[0] = getIntent().getStringExtra("user");
        accInfo[1] = getIntent().getStringExtra("pass");
        accInfo[2] = getIntent().getStringExtra("mail");
        accInfo[3] = getIntent().getStringExtra("orcid");

        findViewById(R.id.Page2to3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nextReady == 5){
                    registerPage3.putExtra("user", accInfo[0]);
                    registerPage3.putExtra("pass", accInfo[1]);
                    registerPage3.putExtra("mail", accInfo[2]);
                    registerPage3.putExtra("orcid", accInfo[3]);
                    registerPage3.putExtra("fname", inputFirstName.getEditText().getText().toString());
                    registerPage3.putExtra("lname", inputLastName.getEditText().getText().toString());
                    registerPage3.putExtra("birth", inputBirthDate.getEditText().getText().toString());
                    registerPage3.putExtra("inst", inputInstitution.getEditText().getText().toString());
                    registerPage3.putExtra("units", inputRUnits.getEditText().getText().toString());
                    startActivity(registerPage3);
                }
            }
        });

        inputFirstName.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String userName = inputFirstName.getEditText().getText().toString();
                boolean problem = false;
                Log.d("fname", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(userName, 3)){
                        Log.d("fname", "length");
                        inputFirstName.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(userName)){
                        //Log.d("fname", "chars");
                        inputFirstName.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputFirstName.setError(null);
                        if(!fNameReady){
                            fNameReady = true;
                            Log.d("Button", "fname");
                            nextReady++;
                        }
                    }else{
                        if(fNameReady){
                            fNameReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputLastName.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String lastName = inputLastName.getEditText().getText().toString();
                boolean problem = false;
                Log.d("lname", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(lastName, 3)){
                        Log.d("lname", "length");
                        inputLastName.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(lastName)){
                        Log.d("lname", "chars");
                        inputLastName.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputLastName.setError(null);
                        if(!lNameReady){
                            lNameReady= true;
                            Log.d("Button", "lname");
                            nextReady++;
                        }
                    }else{
                        if(lNameReady){
                            lNameReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputBirthDate.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String birthDate = inputBirthDate.getEditText().getText().toString();
                boolean problem = false;
                Log.d("birth", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(birthDate, 5)){
                        Log.d("birth", "length");
                        inputBirthDate.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!problem){
                        inputBirthDate.setError(null);
                        if(!birthDateReady){
                            birthDateReady= true;
                            Log.d("Button", "birth");
                            nextReady++;
                        }
                    }else{
                        if(birthDateReady){
                            birthDateReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputInstitution.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String inst = inputLastName.getEditText().getText().toString();
                boolean problem = false;
                Log.d("inst", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(inst, 5)){
                        Log.d("inst", "length");
                        inputInstitution.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(inst)){
                        Log.d("inst", "chars");
                        inputInstitution.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputInstitution.setError(null);
                        if(!institReady){
                            institReady= true;
                            Log.d("Button", "inst");
                            nextReady++;
                        }
                    }else{
                        if(institReady){
                            institReady = false;
                            nextReady--;
                        }
                    }
                }
            }
        });

        inputRUnits.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String units = inputRUnits.getEditText().getText().toString();
                boolean problem = false;
                Log.d("units", "focuschange");
                if(!hasFocus){
                    if(!InputCheck.stringCheckLength(units, 5)){
                        Log.d("units", "length");
                        inputRUnits.setError("User name must have at least 5 characters");
                        problem = true;
                    }
                    if(!InputCheck.stringCheckChars(units)){
                        Log.d("units", "chars");
                        inputRUnits.setError("User name cannot have non alphanumeric characters");
                        problem = true;
                    }
                    if(!problem){
                        inputRUnits.setError(null);
                        if(!rUnitsReady){
                            rUnitsReady= true;
                            Log.d("Button", "units");
                            nextReady++;
                        }
                    }else{
                        if(rUnitsReady){
                            rUnitsReady = false;
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
}
