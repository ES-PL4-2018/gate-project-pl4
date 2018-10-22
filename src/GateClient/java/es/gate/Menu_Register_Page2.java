package es.gate;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu_Register_Page2 extends AppCompatActivity {

    private static final String TAG = "MenuRegisterPage2";
    private Intent openLogin;
    private Intent nextPage;
    private boolean registerP2ready = false;
    private Card_Register_Adapter cardAdapter;
    private TextInputLayout inputInterestsSearch;
    private ArrayList<Card_Interests> interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        setContentView(R.layout.menu_register_p2);

        setupPage2();


        openLogin = new Intent(this, Menu_Login.class);
        nextPage = new Intent(this, Menu_Register_Page3.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("???????????????????????????????'");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("\\\\\\\\\\\\\\\\\\\\");
    }

    private Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message message) {

            switch (message.getData().getString("requestType")) {
                case "checkP2Ready":{
                    checkP2Ready();
                    break;
                }
                case "nextPage2":{
                    startActivity(nextPage);
                    break;
                }
                case "printToast":{
                    Toast.makeText(getApplicationContext(), message.getData().getString("message"), Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    };

    public void registerP2OnClick(View v) {
        Log.d(TAG, "" + v.getId());

        switch (v.getId()) {
            case R.id.registerP2Back: {
                Log.i(TAG, "Page 2 back request");
                super.onBackPressed();
                break;
            }
            case R.id.registerP2Cancel: {
                Log.i(TAG, "Register cancel request");
                setupPage2();
                //startActivity(openLogin);
                break;
            }
            case R.id.registerNextPage2: {
                Log.i(TAG, "Page 2 next page request");

                Message message = handler.obtainMessage();
                Bundle bundle  = new Bundle();
                bundle.putString("requestType", "checkP2Ready");
                message.setData(bundle);
                handler.sendMessage(message);

                break;
            }
        }
    }


    private void setupPage2() {


        inputInterestsSearch = findViewById(R.id.registerReshSearch);

        inputInterestsSearch.getEditText().addTextChangedListener(inputInterestsSearchWatcher);

        Singleton_Interests singletonInterests = Singleton_Interests.getInstance();
        interests = new ArrayList<>();
        interests.addAll(singletonInterests.getInterests());
        RecyclerView recyclerView = findViewById(R.id.registerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new Card_Register_Adapter(interests);
        System.out.println(interests);
        System.out.println(cardAdapter == null);
        recyclerView.setAdapter(cardAdapter);
        registerP2ready = true;

    }

    private void checkP2Ready(){

        Singleton_Interests singletonInterests = Singleton_Interests.getInstance();
        Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();

        ArrayList<Card_Interests> interests =  new ArrayList<>();
        int i = 0;


        for(Card_Interests inter : singletonInterests.getInterests()){

            if(inter.isSelected()){
                interests.add(inter);
                i++;
            }
        }

        if(i > 2){
            userInfo.getAccount().setThemesInterest(interests);

            Message message = handler.obtainMessage();
            Bundle bundle  = new Bundle();
            bundle.putString("requestType", "nextPage2");
            message.setData(bundle);
            handler.sendMessage(message);
        }else{
            Message message = handler.obtainMessage();
            Bundle bundle  = new Bundle();
            bundle.putString("requestType", "printToast");
            bundle.putString("message", "Please select at least 3 interests");
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    private TextWatcher inputInterestsSearchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Singleton_Interests singletonInterests = Singleton_Interests.getInstance();
            System.out.println(interests.size() + "\t" + singletonInterests.getInterests().size());

            if(count == 0){
                interests.clear();
                interests.addAll(singletonInterests.getInterests());
                cardAdapter.notifyDataSetChanged();
                return;
            }

            if(before < count){ //more precise search
                for(int i = 0; i < interests.size(); i++){
                    if(!interests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase())){
                        interests.remove(i);
                        cardAdapter.notifyItemRemoved(i);
                        i--;
                    }
                }

            }else{//less precise search
                ArrayList<Card_Interests> allInterests = singletonInterests.getInterests();
                for (int i = 0; i < allInterests.size(); i++) {
                    if (allInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase()) && !interests.contains(allInterests.get(i))) {
                        int j = 0;
                        for(Card_Interests inter : allInterests){
                            if(inter.equals(allInterests.get(i)))
                                break;
                            if(interests.contains(inter))
                                j++;
                        }
                        interests.add(j, allInterests.get(i));
                        cardAdapter.notifyItemInserted(i);
                        i--;
                    }
                }
            }

            System.out.println(s);
            System.out.println(start);
            System.out.println(before);
            System.out.println(count);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}