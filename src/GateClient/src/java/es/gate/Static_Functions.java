package es.gate;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Static_Functions {

                //---------Compile HashMaps---------\\
    public static HashMap compileLogin(String name, String pass){

        HashMap<String, String> login = new HashMap<>();

        login.put("operation", "login");
        login.put("user", name);
        login.put("pass", pass);

        return login;
    }

    public static HashMap compileRegisterChoice(String type, String info, User_Account acc){

        HashMap registerChoice = new HashMap();

        registerChoice.put("comType", type);
        registerChoice.put("info", info);
        registerChoice.put("acc", acc);

        return registerChoice;
    }

    public static HashMap compileCheckEmail(String email){

        HashMap<String, String> checkEmail = new HashMap<>();

        checkEmail.put("operation", "checkEmail");
        checkEmail.put("email", email);

        return checkEmail;
    }

    public static HashMap compileCheckID(String id){

        HashMap<String, String> checkID = new HashMap<>();

        checkID.put("operation", "checkID");
        checkID.put("id", id);

        return checkID;
    }

    public static HashMap compileFinishRegister(User_Account acc){

        HashMap finishRegister = new HashMap();

        finishRegister.put("operation", "register");
        finishRegister.put("account", acc);

        return finishRegister;
    }

    public static HashMap compileUserWrite(User_Account acc){

        HashMap userWrite = new HashMap();

        userWrite.put("operation", "userWrite");
        userWrite.put("account", acc);
        userWrite.put("user", acc.getUserID());

        return userWrite;

    }

                //---------Check Inputs---------\\
    private static final Pattern patternEMAIL = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" + "@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

    private static final Pattern patternORCID = Pattern.compile(
            "[0-9]{4}+-[0-9]{4}+-[0-9]{4}+-[0-9]{4}");

    public static boolean checkLength(String str, int length){

        return str.length() >= length;
    }

    public static boolean checkEmail(String email){

        return email != null && patternEMAIL.matcher(email).matches();
    }

    public static boolean checkORCID(String str){

        if(str.length() == 0)
            return false;

        String orcid = "";
        int size = str.length() / 4;
        int rest = str.length() % 4;
        int i;

        for(i = 0; i < size; i++){
            orcid = orcid.concat(str.substring(4 * i, 4 + 4 * i) + "-");
        }
        if(rest > 0){
            orcid = orcid.concat(str.substring(4 * i,(4 * i) + rest));
        }else{
            orcid = orcid.substring(0, orcid.length() - 1);
        }

        System.out.println("orcid " + orcid);

        return patternORCID.matcher(orcid).matches() && getORCIDInfo("https://pub.orcid.org/v2.0/" + orcid);//TODO url wrong
    }

    private static boolean getORCIDInfo(String url){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println("orcid " + response.code());
            return response.code() == 200;
        }catch(IOException e){

        }
        return false;
    }

    public static void orcidInfo(){



        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://sandbox.orcid.org/oauth/token")
                    //.post(RequestBody.create(MediaType.parse("application/json", json)))
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println("orcid " + response.code());
           // return response.code() == 200;
        }catch(IOException e){

        }

    }
}
