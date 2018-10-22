package es.gate;

import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Static_InputCheck {

    private static final Pattern patternEMAIL = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" + "@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

    private static final Pattern patternORCID = Pattern.compile(
            "[0-9]{4}+-[0-9]{4}+-[0-9]{4}+-[0-9]{4}");

    static boolean checkLength(String str, int length){

        return str.length() >= length;
    }

    static boolean checkOnlyLetters(String str){

        return str.matches("[A-Za-z]*");
    }

    static boolean checkChars(String str){

        return str.matches("[A-Za-z0-9 ]*");
    }

    static boolean checkEmail(String email){

        return email != null && patternEMAIL.matcher(email).matches();
    }

    static boolean checkORCID(String str){

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

            return patternORCID.matcher(orcid).matches() && getORCIDInfo("https://pub.orcid.org/v2.0/" + orcid);
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
}
