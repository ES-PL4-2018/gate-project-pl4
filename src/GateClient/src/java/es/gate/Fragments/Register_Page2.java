package es.gate.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Register;
import es.gate.R;
import es.gate.Static_Functions;

import java.util.Objects;

/*
public class Register_Page2 extends AppCompatActivity {

    private static final String TAG = "MenuRegisterPage2";
    private Intent openLogin;
    private Intent nextPage;
    private Intent prevPage;
    private boolean registerP2ready = false;
    private Register cardAdapter;
    private TextInputLayout inputInterestsSearch;
    private ArrayList<Interests> interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        setContentView(R.layout.menu_register_p3);

        setupPage2();


        openLogin = new Intent(this, Login.class);
        nextPage = new Intent(this, Register_Page3.class);
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
        cardAdapter = new Register(interests);
        System.out.println(interests);
        System.out.println(cardAdapter == null);
        recyclerView.setAdapter(cardAdapter);
        registerP2ready = true;

    }

    private void checkP2Ready(){

        Singleton_Interests singletonInterests = Singleton_Interests.getInstance();
        Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();

        ArrayList<Interests> interests =  new ArrayList<>();
        int i = 0;


        for(Interests inter : singletonInterests.getInterests()){

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
                ArrayList<Interests> allInterests = singletonInterests.getInterests();
                for (int i = 0; i < allInterests.size(); i++) {
                    if (allInterests.get(i).getInterest().toLowerCase().contains(s.toString().toLowerCase()) && !interests.contains(allInterests.get(i))) {
                        int j = 0;
                        for(Interests inter : allInterests){
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

*/

public class Register_Page2 extends Fragment {

    private Register parent;
    private View registerView;
    private AccountInformation accInfo;
    private TextInputLayout inputFirstName;
    private TextInputLayout inputLastName;
    private TextInputLayout inputUserEmail;
    private TextInputLayout inputInstitution;
    private TextInputLayout inputInvestigation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        registerView  = inflater.inflate(R.layout.menu_register_p2, container, false);
        parent = (es.gate.Menus.Register) getActivity();

        try {
            accInfo = Objects.requireNonNull(parent).getInfo();
        }catch (NullPointerException e){
            Log.d("RegisterPage2", "Parent was null");
        }

        inputSetup();

        registerView.findViewById(R.id.registerNextPage2).setOnClickListener(nextPage);

        return registerView;
    }

    public void inputSetup(){

        inputFirstName = registerView.findViewById(R.id.registerFirstNameInput);
        inputLastName = registerView.findViewById(R.id.registerLastNameInput);
        inputUserEmail = registerView.findViewById(R.id.registerEmailInput);
        inputInstitution = registerView.findViewById(R.id.registerInstitutionInput);
        inputInvestigation = registerView.findViewById(R.id.registerInvestigationInput);

        try {
            Objects.requireNonNull(inputFirstName.getEditText()).setText(accInfo.getUserFirstName());
            Objects.requireNonNull(inputLastName.getEditText()).setText(accInfo.getUserLastName());
            if(!accInfo.getUserEmail().equals("[]")){
                Objects.requireNonNull(inputUserEmail.getEditText()).setText(accInfo.getUserEmail());
            }
            Objects.requireNonNull(inputInstitution.getEditText()).setText(accInfo.getInstitution());
            Objects.requireNonNull(inputInvestigation.getEditText()).setText(accInfo.getInvestigationUnits());
        }catch (NullPointerException e){
            Log.d("RegisterPage2", "TextInput getText returned null when setting info");
        }
    }

    private void updateInfo(){

        try {
            accInfo.setUserFirstName(Objects.requireNonNull(inputFirstName.getEditText()).getText().toString());
            accInfo.setUserLastName(Objects.requireNonNull(inputLastName.getEditText()).getText().toString());
            accInfo.setUserEmail(Objects.requireNonNull(inputUserEmail.getEditText()).getText().toString());
            accInfo.setInstitution(Objects.requireNonNull(inputInstitution.getEditText()).getText().toString());
            accInfo.setInvestigationUnits(Objects.requireNonNull(inputInvestigation.getEditText()).getText().toString());
        }catch(NullPointerException e){
            Log.d("RegisterPage2", "TextInput getText returned null when updatting info");
            Toast.makeText(getContext(), "Error updating info", Toast.LENGTH_LONG).show();
            return;
        }

        parent.registerPage(2);
    }

    private View.OnClickListener nextPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            boolean validInfo = true;


            try{
                if(!Static_Functions.checkLength(Objects.requireNonNull(inputFirstName.getEditText()).getText().toString(), 0)){
                    inputFirstName.setError(" ");
                    validInfo = false;
                }
            }catch(NullPointerException e){
                Log.d("RegisterPage2", "First Name getText was null");
            }
            try{
                if(!Static_Functions.checkLength(Objects.requireNonNull(inputLastName.getEditText()).getText().toString(), 0)){
                    inputLastName.setError(" ");
                    validInfo = false;
                }
            }catch(NullPointerException e){
                Log.d("RegisterPage2", "Last Name getText was null");
            }
            try{
                if(!Static_Functions.checkEmail(Objects.requireNonNull(inputUserEmail.getEditText()).getText().toString())){
                    inputUserEmail.setError(" ");
                    validInfo = false;
                }
            }catch(NullPointerException e){
                Log.d("RegisterPage2", "Email getText was null");
            }
            try{
                if(!Static_Functions.checkLength(Objects.requireNonNull(inputInstitution.getEditText()).getText().toString(), 0)){
                    inputInstitution.setError(" ");
                    validInfo = false;
                }
            }catch(NullPointerException e){
                Log.d("RegisterPage2", "Institution getText was null");
            }
            try{
                if(!Static_Functions.checkLength(Objects.requireNonNull(inputInvestigation.getEditText()).getText().toString(), 0)){
                    inputInvestigation.setError(" ");
                    validInfo = false;
                }
            }catch(NullPointerException e){
                Log.d("RegisterPage2", "Investigation getText was null");
            }

            if(!validInfo){

                Toast.makeText(getContext(), "Please verify your personal information", Toast.LENGTH_LONG).show();
            }else{
                updateInfo();
            }
        }
    };
}