/*
###File created at 01/10/2018 3:53
###Created by Alexandre Brito

##Revision v0.1
#1/10/2018 3:53
#Alexandre Brito
#Initial Criation



*/
package es.gate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RegisterP3Activity extends AppCompatActivity {

    private Intent newsFeed;
    private volatile int registerReady = 0;
    private TextInputLayout inputFirstName;
    private TextInputLayout inputLastName;
    private TextInputLayout inputBirthDate;
    private TextInputLayout inputInstitution;
    private TextInputLayout inputRUnits;
    private String accInfo[];
    private ArrayList<View> buttons;
    private int buttonOn[];
    private Drawable buttonsBG[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_p3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(249, 143, 116)));
        buttons = new ArrayList<>();

        newsFeed = new Intent(this, Feed.class);

        buttons.add(findViewById(R.id.themeCompScience));
        buttons.add(findViewById(R.id.themeMathematics));
        buttons.add(findViewById(R.id.themePhysics));
        buttons.add(findViewById(R.id.themeChemistry));
        buttons.add(findViewById(R.id.themeBiology));
        buttons.add(findViewById(R.id.themeGeology));
        buttons.add(findViewById(R.id.themeNeurology));
        buttons.add(findViewById(R.id.themePsychology));

        buttonOn = new int[8];
        buttonsBG = new Drawable[2];
    }

    @Override
    protected void onStart(){

        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selection = 0;
                for(int i : buttonOn){
                    selection+= i;
                }
                Log.d("Ready", "" + selection);
                if(selection >= 3)
                    new Thread(new serverConnect(getThemes())).start();

            }
        });

        accInfo = new String[9];
        accInfo[0] = getIntent().getStringExtra("user");
        accInfo[1] = getIntent().getStringExtra("pass");
        accInfo[2] = getIntent().getStringExtra("mail");
        accInfo[3] = getIntent().getStringExtra("orcid");
        accInfo[4] = getIntent().getStringExtra("fname");
        accInfo[5] = getIntent().getStringExtra("lname");
        accInfo[6] = getIntent().getStringExtra("birth");
        accInfo[7] = getIntent().getStringExtra("inst");
        accInfo[8] = getIntent().getStringExtra("units");

        buttonsBG[0] = getResources().getDrawable(R.drawable.button_round_corners, getTheme());
        buttonsBG[1] = getResources().getDrawable(R.drawable.button_selected, getTheme());

        for(int i = 0; i < 8; i++){
            final int j = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickButton(buttons.get(j), j);
                }
            });
        }
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

    private void clickButton(View button, int id){

        int index = buttons.indexOf(button);

        buttonOn[index] += 1;
        buttonOn[index] = buttonOn[index]%2;
        Log.d("Button", "changed" + buttonOn[index]);

        ((Button)buttons.get(index)).setBackground(buttonsBG[buttonOn[index]]);
    }

    class serverConnect implements Runnable {

        private String themes;

        public serverConnect(String themes) {
            this.themes = themes;
        }

        @Override
        public void run() {
            ServerConnection srv = ServerConnection.getInstance();
            Log.d("threadRun", "start");

            String communication = String.format("!register&%s&%s&%s&%s&%s&%s&%s&%s&%s&%s", accInfo[0], accInfo[1], accInfo[2], accInfo[3], accInfo[4], accInfo[5], accInfo[6], accInfo[7], accInfo[8], themes);

            communication = srv.sendMessage(communication);

            int response = Integer.parseInt(communication);

            if(response == 1){
                startActivity(newsFeed);
            }
        }
    }

    private String getThemes(){

        String themes = "";

        if(buttonOn[0] == 1)
            themes = themes.concat("Computer Science><");

        if(buttonOn[1] == 1)
            themes = themes.concat("Mathematics><");

        if(buttonOn[2] == 1)
            themes = themes.concat("Physics><");

        if(buttonOn[3] == 1)
            themes = themes.concat("Chemistry><");

        if(buttonOn[4] == 1)
            themes = themes.concat("Biology><");

        if(buttonOn[5] == 1)
            themes = themes.concat("Computer Geology><");

        if(buttonOn[6] == 1)
            themes = themes.concat("Neurology><");

        if(buttonOn[7] == 1)
            themes = themes.concat("Psychology><");

        return themes;
    }


}
