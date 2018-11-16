package es.gate.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.Menus.Login;
import es.gate.Menus.Main;
import es.gate.R;
import es.gate.Static_Functions;
import io.realm.Realm;
import io.realm.RealmList;

import java.util.Objects;
import java.util.StringTokenizer;

public class Profile extends Fragment {

    private View profileView;
    private es.gate.Cards.Adapters.Profile cardAdapter;
    private boolean isEditing = false;
    private TextView userOrcid;
    private EditText inputName;
    private EditText inputInstitution;
    private EditText inputInvestigation;
    private EditText inputNewInterest;
    private ImageView addNewInterest;
    private ImageView leftImage;
    private ImageView rightImage;
    private TwitterLoginButton loginButton;
    private TextView userTwitterName;
    private Intent openLogin;
    private Intent openOrcid;
    private Realm realm;
    private Profile thisProfile;
    private RecyclerView recyclerView;
    private String curAccount;
    private View.OnClickListener addInterest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (thisProfile.isEditing() && !inputNewInterest.getText().toString().trim().equals("")) {
                realm = Realm.getDefaultInstance();
                RealmList<String> interests = Objects.requireNonNull(realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst()).getInterests();

                realm.beginTransaction();
                interests.add(inputNewInterest.getText().toString().trim());
                realm.commitTransaction();
                realm.close();

                inputNewInterest.setText("");
                cardAdapter = new es.gate.Cards.Adapters.Profile(thisProfile, curAccount);
                recyclerView.setAdapter(cardAdapter);

            }
        }
    };
    private View.OnClickListener openOrcidProfile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(openOrcid);
        }
    };

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.menu_profile, container, false);
        thisProfile = this;

        curAccount = ((Main) Objects.requireNonNull(getActivity())).getCurAccount();

        recyclerView = view.findViewById(R.id.profileRecyclerView);
        recyclerView.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new es.gate.Cards.Adapters.Profile(this, curAccount);
        recyclerView.setAdapter(cardAdapter);

        userOrcid = view.findViewById(R.id.profileOrcid);
        inputName = view.findViewById(R.id.profileUserNameInput);
        inputInstitution = view.findViewById(R.id.profileInstitutionInput);
        inputInvestigation = view.findViewById(R.id.profileResearchUnitInput);
        inputNewInterest = view.findViewById(R.id.profileInterestSearch);
        leftImage = view.findViewById(R.id.profileLeftImage);
        rightImage = view.findViewById(R.id.profileRightImage);
        addNewInterest = view.findViewById(R.id.profileAddInterest);
        userTwitterName = view.findViewById(R.id.profileTwitterName);
        loginButton = view.findViewById(R.id.login_button);

        final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                .getActiveSession();
        if (session != null) {
            loginButton.setVisibility(View.INVISIBLE);
            loginButton.setEnabled(false);
            userTwitterName.setVisibility(View.VISIBLE);
            userTwitterName.setText("@" + session.getUserName());
        } else {
            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    loginButton.setVisibility(View.INVISIBLE);
                    loginButton.setEnabled(false);
                    userTwitterName.setVisibility(View.VISIBLE);
                    userTwitterName.setText("@" + result.data.getUserName());
                }

                @Override
                public void failure(TwitterException exception) {
                }
            });
        }

        openLogin = new Intent(this.getContext(), Login.class);

        leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEditing) {
                    Objects.requireNonNull(getActivity()).finish();
                    startActivity(openLogin);
                    TwitterCore.getInstance().getSessionManager().clearActiveSession();
                } else {
                    profileRemoveEditing();
                    profileResetInfo();
                }
            }
        });

        rightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEditing) {
                    isEditing = true;
                    profileSetEditing();
                } else {
                    isEditing = false;
                    profileRemoveEditing();
                    profileSetNewInfo();
                }
            }
        });

        addNewInterest.setOnClickListener(addInterest);

        profileResetInfo();
        profileView = view;
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    private void profileSetNewInfo() {

        //ToDo

        realm = Realm.getDefaultInstance();

        AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();

        StringTokenizer token = new StringTokenizer(inputName.getText().toString().trim());

        assert accInfo != null;
        realm.beginTransaction();
        accInfo.setUserFirstName(token.nextToken());
        accInfo.setUserLastName(token.nextToken());
        accInfo.setInstitution(inputInstitution.getText().toString());
        accInfo.setInvestigationUnits(inputInvestigation.getText().toString());
        realm.commitTransaction();

        realm.close();

    }

    private void profileResetInfo() {

        realm = Realm.getDefaultInstance();

        AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();

        assert accInfo != null;
        String orcid = Static_Functions.formatORCID(accInfo.getOrcid());

        userOrcid.setText(orcid);
        userOrcid.setOnClickListener(openOrcidProfile);
        inputName.setText(String.format("%s %s", accInfo.getUserFirstName(), accInfo.getUserLastName()));
        inputInstitution.setText(accInfo.getInstitution());
        inputInvestigation.setText(accInfo.getInvestigationUnits());

        openOrcid = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orcid.org/" + orcid));

        realm.close();
    }

    private void profileSetEditing() {
        inputName.setFocusableInTouchMode(true);
        inputInstitution.setFocusableInTouchMode(true);
        inputInvestigation.setFocusableInTouchMode(true);
        inputNewInterest.setFocusableInTouchMode(true);
        addNewInterest.setVisibility(View.VISIBLE);
        inputName.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.white, null)));
        inputInstitution.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.white, null)));
        inputInvestigation.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.white, null)));
        inputNewInterest.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.white, null)));

        rightImage.setImageResource(R.drawable.profile_edit_confirm);
        leftImage.setImageResource(R.drawable.profile_cancel);

    }

    private void profileRemoveEditing() {
        inputName.setFocusable(false);
        inputInstitution.setFocusable(false);
        inputInvestigation.setFocusable(false);
        inputNewInterest.setFocusable(false);
        inputNewInterest.setText("");
        addNewInterest.setVisibility(View.INVISIBLE);
        inputName.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.black, null)));
        inputInstitution.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.black, null)));
        inputInvestigation.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.black, null)));
        inputNewInterest.setBackgroundTintList(ColorStateList.valueOf(profileView.getResources().getColor(R.color.transparent, null)));

        rightImage.setImageResource(R.drawable.profile_edit);
        leftImage.setImageResource(R.drawable.profile_logout);
    }

    public boolean isEditing() {
        return isEditing;
    }

    public View getView() {
        return profileView;
    }

    public int getFragmentID() {
        return thisProfile.getId();
    }
}
