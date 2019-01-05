package es.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import es.gate.Menus.Login;
import io.realm.Realm;

public class InitiationClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Realm.init(this);
        finish();
        startActivity(new Intent(this, Login.class));

    }

}
