package es.gate;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Fragment_Profile extends Fragment {

    private View profileView;
    private Card_Profile_Adapter cardAdapter;
    private ArrayList<Card_Interests> userInterests;
    private boolean isEditing = false;
    private TextView userName;
    private EditText inputName;
    private EditText inputInstitution;
    private EditText inputInvestigation;
    private EditText inputResearchCenter;
    private ImageView leftImage;
    private ImageView rightImage;
    private Intent openLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.menu_profile, container, false);

        final Singleton_Interests interests = Singleton_Interests.getInstance();

        userInterests = interests.getSelectedInterests();

        RecyclerView recyclerView = view.findViewById(R.id.profileRecyclerView);
        recyclerView.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new Card_Profile_Adapter(userInterests);
        recyclerView.setAdapter(cardAdapter);

        userName = view.findViewById(R.id.profileName);
        inputName = view.findViewById(R.id.profileUserNameInput);
        inputInstitution = view.findViewById(R.id.profileInstitutionInput);
        inputInvestigation = view.findViewById(R.id.profileResearchUnitInput);
        inputResearchCenter = view.findViewById(R.id.profileResearchCenterInput);
        leftImage = view.findViewById(R.id.profileLeftImage);
        rightImage = view.findViewById(R.id.profileRightImage);

        openLogin =  new Intent(this.getContext(), Menu_Login.class);

        leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEditing){
                    startActivity(openLogin);
                }else{
                    profileRemoveEditing();
                    profileResetInfo();
                }
            }
        });

        rightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEditing){
                    isEditing = true;

                    inputName.setFocusableInTouchMode(true);
                    inputInstitution.setFocusableInTouchMode(true);
                    inputInvestigation.setFocusableInTouchMode(true);
                    inputResearchCenter.setFocusableInTouchMode(true);
                    inputName.setBackgroundTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.white, null)));
                    inputInstitution.setBackgroundTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.white, null)));
                    inputInvestigation.setBackgroundTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.white, null)));
                    inputResearchCenter.setBackgroundTintList(ColorStateList.valueOf(v.getResources().getColor(R.color.white, null)));
                    userInterests.clear();
                    userInterests.addAll(interests.getInterests());
                    cardAdapter.notifyDataSetChanged();
                    cardAdapter.setButtonsVisible();

                    rightImage.setImageResource(R.drawable.profile_edit_confirm);
                    leftImage.setImageResource(R.drawable.profile_cancel);

                }else{
                    isEditing = false;

                    profileRemoveEditing();

                    profileSetNewInfo();
                }

            }
        });


        profileResetInfo();
        profileView = view;
        return view;
    }

    public void profileSetNewInfo(){

        Singleton_UserInformation userInfo = Singleton_UserInformation.getInstance();

        User_Account userAcc = userInfo.getAccount();

        StringTokenizer token = new StringTokenizer(inputName.getText().toString().trim());

        userAcc.setFirstName(token.nextToken());
        userAcc.setLastName(token.nextToken());
        userAcc.setInstitution(inputInstitution.getText().toString());
        userAcc.setInvestigation(inputInvestigation.getText().toString());
        userAcc.setResearchUnits(inputResearchCenter.getText().toString());

        userAcc.setThemesInterest(userInterests);

        cardAdapter.notifyDataSetChanged();

        new Thread(new serverConnect()).start();

    }

    public void profileResetInfo(){

        ArrayList<Card_Interests> allInterest = new ArrayList<>();

        Singleton_Interests.getInstance().insertInterests(allInterest);

        User_Account userAcc;

        do{
            userAcc = Singleton_UserInformation.getInstance().getAccount();
            System.out.println(userAcc);
        }while(userAcc == null);

        userName.setText(userAcc.getUserID());
        inputName.setText(String.format("%s %s", userAcc.getFirstName(), userAcc.getLastName()));
        inputInstitution.setText(userAcc.getInstitution());
        inputInvestigation.setText(userAcc.getInvestigation());
        inputResearchCenter.setText(userAcc.getResearchUnits());

        userInterests.clear();

        userInterests.addAll(userAcc.getThemesInterest());

        /*

        ArrayList<String> selected = userAcc.getThemesInterest();
        for(Card_Interests i : allInterest){
            System.out.println(i.getInterest());
            if(selected.contains(i.getInterest())){
                userInterests.add(i);
                i.setSelected(true);
            }else{
                i.setSelected(false);
            }
        }
        */

        cardAdapter.notifyDataSetChanged();
        cardAdapter.setButtonsInvisible();


    }

    public void profileRemoveEditing(){
        inputName.setFocusable(false);
        inputInstitution.setFocusable(false);
        inputInvestigation.setFocusable(false);
        inputResearchCenter.setFocusable(false);
        inputName.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.transparent, null)));
        inputInstitution.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.transparent, null)));
        inputInvestigation.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.transparent, null)));
        inputResearchCenter.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.transparent, null)));

        for(Card_Interests ci : Singleton_Interests.getInstance().getInterests()){
            if(!ci.isSelected()){
                userInterests.remove(ci);
            }
        }
        cardAdapter.notifyDataSetChanged();
        cardAdapter.setButtonsInvisible();

        rightImage.setImageResource(R.drawable.profile_edit);
        leftImage.setImageResource(R.drawable.profile_logout);
    }

    public View getView(){
        return profileView;
    }

    class serverConnect implements Runnable {

        private static final String TAG = "Menu_LoginThread";

        @Override
        public void run() {

            Singleton_ServerConnection srv = Singleton_ServerConnection.getInstance();
            Singleton_UserInformation info = Singleton_UserInformation.getInstance();

            Log.d(TAG, "Thread starting");

            HashMap communication = Static_HashCompiler.compileUserWrite(info.getAccount());

            communication = srv.sendMessage(communication);

            System.out.println(communication.get("writeResult"));
        }
    }

}
