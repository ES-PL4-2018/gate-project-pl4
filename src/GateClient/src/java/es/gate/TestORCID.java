package es.gate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.gson.Gson;
import com.mopub.common.util.Json;
import es.gate.DatabaseClasses.AccountInformation;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

public class TestORCID {
    OkHttpClient client = new OkHttpClient();
    // code request code here
    String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization_type", "Bearer")
                .addHeader("Access_token", "80948901-a164-49cb-b892-aeea1cbdf986")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // post request code here

    public static final MediaType JSON
            = MediaType.parse("application/json");

    // test data
    String bowlingJson(String id, String secret) {
        return "{'client_id'=" + id + ","
                + "'client_secret'=" + secret + ","
                + "'grant_type'='client_credentials',"
                + "'client_credentials'='/read-public'"
                + "}";
    }

    String doPostRequest(String url, String id, String secret) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add("client_id", id)
                .add("client_secret", secret)
                .add("grant_type", "client_credentials")
                .add("scope","/read-public")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static HashMap createHash(String input) throws IOException {
        String propertiesFormat = input.replaceAll(",", "\n");
        Properties properties = new Properties();
        properties.load(new StringReader(propertiesFormat));
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        HashMap<String,String > map = new HashMap<String, String>();
        for (Iterator<Map.Entry<Object, Object>> it = entrySet.iterator(); it.hasNext();) {
            Map.Entry<Object,Object> entry = it.next();
            map.put((String)entry.getKey(), (String)entry.getValue());
        }
        return map;
    }

    public static String getKeywords(TestORCID example, String orcid) throws IOException {
        String getResponse = example.doGetRequest("https://pub.orcid.org/v2.1/" + orcid + "/keywords");
        String keywords = "";
        Gson gson = new Gson();
        HashMap a = gson.fromJson(getResponse, HashMap.class);
        String hash = a.toString();
        String[] str = hash.split(",");
        for (int i=0;i<str.length;i++){
            if(str[i].contains("content=")){
                keywords += str[i].replace("content=","") + ",";
            }
        }
        if(keywords.length()>=3){
            keywords = keywords.substring(0,keywords.length()-1);
        }

        return keywords;
    }

    public static void returnOrcidInfo(String orcid) throws IOException {
        // issue the Get request
        TestORCID example = new TestORCID();
        String getResponse = example.doGetRequest("https://pub.orcid.org/v2.1/" + orcid);
        String keywords = getKeywords(example,orcid);
        String name ="",lastName="",organization="";
        //System.out.println(getResponse);


        // issue the post request
        //String json = example.bowlingJson("APP-OFHD8T3N2AWQE7Z9", "5a099bc5-56d0-4ca5-815e-31363eb8732c");
        //String postResponse = example.doPostRequest("https://pub.orcid.org/oauth/token", "APP-OFHD8T3N2AWQE7Z9", "5a099bc5-56d0-4ca5-815e-31363eb8732c");


        Gson gson = new Gson();
        HashMap a = gson.fromJson(getResponse, HashMap.class);
        HashMap h = createHash(a.toString());

        try{
            name = h.get("given-names").toString();
            lastName = h.get("family-name").toString();
        }catch (NullPointerException n){

        }
        try{
            organization = h.get("organization").toString();
        }catch (NullPointerException n){

        }


        name = name.replace("{value=", "").replace("}", "");
        lastName = lastName.replace("{value=", "").replace("}", "");
        organization = organization.replace("{name=","");

        System.out.println("First Name: " + name);
        System.out.println("Last Name: " + lastName);
        System.out.println("Organization: " + organization);
        System.out.println("Keywords: " + keywords);
        System.out.println("Email: " + h.get("email"));
        //se o email nao existe pode dar return de [] ou null
    }


    public static void main(String[] args) throws IOException {

        returnOrcidInfo("0000-0002-6122-3035");
    }
}