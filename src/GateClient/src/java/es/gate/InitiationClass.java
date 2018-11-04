package es.gate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import es.gate.Menus.Login;

public class InitiationClass extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


     /*
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        System.out.println(realm.isEmpty());
        DBTest acc = realm.where(DBTest.class).findFirst();

        System.out.println("??");

        System.out.println("start");
        realm.beginTransaction();
        realm.copyToRealm(acc);
        realm.commitTransaction();
        System.out.println("end");

        realm.close();

        DBTest acc;
        realm.beginTransaction();
        acc = realm.where(DBTest.class).findFirst();
        realm.commitTransaction();

        System.out.println(acc.getName());

        realm.close();

*/
     finish();
     startActivity(new Intent(this, Login.class));

    }

}
