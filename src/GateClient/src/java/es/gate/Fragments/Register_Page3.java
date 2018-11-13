package es.gate.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import es.gate.*;
import es.gate.Cards.Interests;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Register;
import io.realm.RealmList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
public class Register_Page3 extends AppCompatActivity {

    private static final String TAG = "MenuRegister";
    private Intent openMain;
    private Intent openLogin;
    private TextInputLayout inputUserName;
    private TextInputLayout inputUserPass;
    private TextInputLayout inputUserPassConfirm;
    private boolean registerP3ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPage3();

        openMain = new Intent(this, Main.class);
        openLogin = new Intent(this, Login.class);

    }

    private Handler handler = new  Handler() {
        @Override
        public void handleMessage(Message message) {

            switch (message.getData().getString("requestType")) {
                case "verifyP3Inputs": {
                    verifyP3Inputs();
                    break;
                }
                case "checkP3Ready": {
                    checkP3Ready();
                    break;
                }
                case "finishRegister": {
                    startActivity(openMain);
                    break;
                }
                case "printToast":{
                    Toast.makeText(getApplicationContext(), message.getData().getString("message"), Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    };

    public void registerP3OnClick(View v) {
        Log.d(TAG, "" + v.getId());

        switch (v.getId()) {
            case R.id.registerP3Back: {
                Log.i(TAG, "Page 3 back request");
                super.onBackPressed();
                break;
            }
            case R.id.registerP3Cancel: {
                Log.i(TAG, "Register cancel request");
                startActivity(openLogin);
                break;
            }
            case R.id.registerRegisterButton: {
                Log.i(TAG, "Register completion request");

                Message message = handler.obtainMessage();
                Bundle bundle  = new Bundle();
                bundle.putString("requestType", "verifyP3Inputs");
                message.setData(bundle);
                handler.sendMessage(message);
                break;
            }

        }
    }

    private void setupPage3(){

        setContentView(R.layout.menu_register_p1);

        inputUserName = findViewById(R.id.registerUserName);
        inputUserPass = findViewById(R.id.registerPass);
        inputUserPassConfirm = findViewById(R.id.registerConfirmPass);

        registerP3ready = true;
    }

    private void verifyP3Inputs() {

        String id = inputUserName.getEditText().getText().toString();
        String pass = inputUserPass.getEditText().getText().toString();
        String confirmPass = inputUserPassConfirm.getEditText().getText().toString();

        registerP3ready = true;

        if(!Static_Functions.checkLength(id, 3)){
            inputUserName.setError(" ");
            registerP3ready = false;
        }else{
            inputUserName.setError(null);
        }

        if(!Static_Functions.checkLength(pass, 3)){
            inputUserPass.setError(" ");
            registerP3ready = false;
        }else{
            inputUserPass.setError(null);
        }

        if(!Static_Functions.checkLength(confirmPass, 3)){
            inputUserPassConfirm.setError(" ");
            registerP3ready = false;
        }else{
            inputUserPassConfirm.setError(null);
        }

        if(pass.equals(confirmPass)){
            new Thread(new NetworkCommunication(Static_Functions.compileRegisterChoice("page3", id, null))).start();
        }else{
            Message message = handler.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString("requestType", "printToast");
            bundle.putString("message", "Passwords must match");
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    private void checkP3Ready(){


        if(registerP3ready){
            System.out.println("Yeeeeeeeee");
            Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();

            userInfo.setIdPass(inputUserName.getEditText().getText().toString(), inputUserPass.getEditText().getText().toString());

            new Thread(new NetworkCommunication(Static_Functions.compileRegisterChoice("finishRegister", null, userInfo.getAccount()))).start();

        }
    }


    private class NetworkCommunication implements Runnable {


        HashMap info;

        public NetworkCommunication(HashMap info) {
            this.info = info;
        }


        @Override
        public void run() {
            switch ((String) info.get("comType")) {
                case "page3": {
                    page3();
                    break;
                }
                case "finishRegister": {
                    finishRegister();
                    break;
                }
            }
        }

        private void page3() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileCheckID((String) info.get("info"));

            communication = srv.sendMessage(communication);

            System.out.println(communication);

            if ((boolean) communication.get("checkIDResult")) {
                System.out.println("ye");
                Message toast = handler.obtainMessage();
                Bundle toastBundle = new Bundle();
                toastBundle.putString("requestType", "printToast");
                toastBundle.putString("message", "Username already used");
                toast.setData(toastBundle);
                handler.sendMessage(toast);
            } else {
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("requestType", "checkP3Ready");
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }

        private void finishRegister() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Log.d(TAG, "Thread starting");

            HashMap communication = Static_Functions.compileFinishRegister((User_Account) info.get("acc"));

            communication = srv.sendMessage(communication);

            System.out.println(communication);

            if ((boolean) communication.get("registerResult")) {
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("requestType", "finishRegister");
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }
    }

}

*/
public class Register_Page3 extends Fragment {

    private View registerView;
    private AccountInformation accInfo;
    private es.gate.Cards.Adapters.Register cardAdapter;
    private TextInputLayout inputInterestsSearch;
    private ArrayList<Interests> allInterests;
    private ArrayList<Interests> curInterests;
    private Register parent;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        registerView  = inflater.inflate(R.layout.menu_register_p3, container, false);
        parent = (es.gate.Menus.Register) getActivity();

        assert parent != null;
        accInfo = parent.getInfo();

        registerView.findViewById(R.id.registerRegisterButton).setOnClickListener(finishRegister);
        registerView.findViewById(R.id.registerAddInterest).setOnClickListener(addInterest);

        setupPage();

        return registerView;
    }

    private void setupPage() {


        inputInterestsSearch = registerView.findViewById(R.id.registerReshSearch);

        try {
            Objects.requireNonNull(inputInterestsSearch.getEditText()).addTextChangedListener(inputInterestsSearchWatcher);
        }catch(NullPointerException e){
            Log.d("RegisterPage3", "getEditText was null");
        }

        allInterests = new ArrayList<>();
        curInterests = new ArrayList<>();
        addInterests();
        curInterests.addAll(allInterests);
        RecyclerView recyclerView = registerView.findViewById(R.id.registerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cardAdapter = new es.gate.Cards.Adapters.Register(curInterests);
        recyclerView.setAdapter(cardAdapter);
    }

    private void addInterests(){

        allInterests.add(new Interests("Informatics"));
        allInterests.add(new Interests("Medicine"));
        allInterests.add(new Interests("Biology"));
        allInterests.add(new Interests("Physics"));
        allInterests.add(new Interests("Astronomy"));
        allInterests.add(new Interests("Chemistry"));
        allInterests.add(new Interests("Mathematics"));
        allInterests.add(new Interests("Geology"));
        allInterests.add(new Interests("Systems Theory"));
        allInterests.add(new Interests("Computer Science"));
        allInterests.add(new Interests("Engineering"));
    }

    private TextWatcher inputInterestsSearchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(count == 0){
                curInterests.clear();
                curInterests.addAll(allInterests);
                cardAdapter.notifyDataSetChanged();
                return;
            }

            if(before < count){ //more precise search
                for(int i = 0; i < curInterests.size(); i++){
                    if(!curInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase())){
                        curInterests.remove(i);
                        cardAdapter.notifyItemRemoved(i);
                        i--;
                    }
                }

            }else{ //less precise search
                for (int i = 0; i < allInterests.size(); i++) {
                    if (allInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase()) && !curInterests.contains(allInterests.get(i))) {
                        int j = 0;
                        for(Interests inter : allInterests){
                            if(inter.equals(allInterests.get(i)))
                                break;
                            if(curInterests.contains(inter))
                                j++;
                        }
                        curInterests.add(j, allInterests.get(i));
                        cardAdapter.notifyItemInserted(i);
                        i--;
                    }
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private View.OnClickListener addInterest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Objects.requireNonNull(inputInterestsSearch.getEditText()).getText().length() > 0) {
                try {
                    allInterests.add(new Interests(Objects.requireNonNull(inputInterestsSearch.getEditText()).getText().toString()));
                    allInterests.get(allInterests.size()-1).setSelected();
                    curInterests.add(allInterests.get(allInterests.size()-1));
                    cardAdapter.notifyItemInserted(allInterests.size()-1);
                } catch (NullPointerException e) {
                    Log.d("RegisterPage3", "getEditText adding was null");
                }
            }
        }
    };

    private View.OnClickListener finishRegister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = 0;

            RealmList<String> interests = new RealmList<>();

            for(Interests inter : curInterests){

                if(inter.isSelected()){
                    interests.add(inter.getInterest());
                    i++;
                }
            }

            if(i > 2){
                accInfo.setInterests(interests);
                parent.registerPage(3);
            }else{
                Toast.makeText(getContext(), "Please select at least 3 interests", Toast.LENGTH_LONG).show();
            }
        }
    };
}

