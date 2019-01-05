package es.gate.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import es.gate.BottomViewNavigation.BottomBarAdapter;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Fragments.Register_Page1;
import es.gate.Fragments.Register_Page2;
import es.gate.Fragments.Register_Page3;
import es.gate.R;
import io.realm.Realm;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    //private Main parent;
    //private View registerView;
    private ViewPager viewPager;
    private Register_Page2 registerPage2;
    private Intent openLogin;
    private Intent openMain;

    private AccountInformation accInfo;

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_register);

        openLogin = new Intent(getApplicationContext(), Login.class);
        openMain = new Intent(getApplicationContext(), Main.class);

        accInfo = new AccountInformation();

        setupRegisterViewPager();
    }

    public void registerPage(int event) {

        switch (event) {
            case 0: {
                viewPager.setCurrentItem(0);
                break;
            }
            case 1: {
                registerPage2.inputSetup();
                viewPager.setCurrentItem(1);
                break;
            }
            case 2: {
                viewPager.setCurrentItem(2);
                break;
            }
            case 3: {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.copyToRealm(accInfo);
                realm.commitTransaction();
                realm.close();
                finish();
                openMain.putExtra("curAccount", accInfo.getOrcid());
                finish();
                startActivity(openMain);
                break;
            }
            case -1: {
                finish();
                startActivity(openLogin);
                break;
            }
        }
    }

    public void OnClick(View v) {

        switch (v.getId()) {

            case R.id.registerCancel: {

                finish();
                startActivity(openLogin);
                break;
            }
            case R.id.registerP2Back: {

                viewPager.setCurrentItem(0);
                break;
            }
            case R.id.registerP3Back: {

                viewPager.setCurrentItem(1);
                break;
            }
            case R.id.registerUploadPhoto: {
                //TODO upload photo
                break;
            }
        }
    }

    public AccountInformation getInfo() {
        return accInfo;
    }

    public void setInfo(HashMap userInfo) {

        accInfo.setOrcid((String) userInfo.get("orcid"));
        accInfo.setPassword((String) userInfo.get("password"));
        accInfo.setUserFirstName((String) userInfo.get("FirstName"));
        accInfo.setUserLastName((String) userInfo.get("LastName"));
        accInfo.setInstitution((String) userInfo.get("Institution"));
        accInfo.setUserEmail((String) userInfo.get("Email"));
    }

    private void setupRegisterViewPager() {

        viewPager = findViewById(R.id.registerViewPager);
        BottomBarAdapter barAdapter = new BottomBarAdapter(getSupportFragmentManager());

        Register_Page1 registerPage1 = new Register_Page1();
        registerPage2 = new Register_Page2();
        Register_Page3 registerPage3 = new Register_Page3();


        barAdapter.addFragments(registerPage1);
        barAdapter.addFragments(registerPage2);
        barAdapter.addFragments(registerPage3);

        viewPager.setAdapter(barAdapter);
    }
}
