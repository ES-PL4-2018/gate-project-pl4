/*
##File created at 26/09/2018 2:15
##Created by Alexandre Brito

#Revision v0.1 - Alexandre Brito

 */

package es.gate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new Connection("10.0.2.2", 9001);
    }
}
