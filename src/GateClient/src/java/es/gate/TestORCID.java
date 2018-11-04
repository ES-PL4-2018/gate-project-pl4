package es.gate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static void main(String[] args) throws IOException {

        // issue the Get request
        TestORCID example = new TestORCID();
        String getResponse = example.doGetRequest("https://pub.orcid.org/v2.0/0000-0002-1825-0097/activities");
        //System.out.println(getResponse);


        // issue the post request
        //String json = example.bowlingJson("APP-OFHD8T3N2AWQE7Z9", "5a099bc5-56d0-4ca5-815e-31363eb8732c");
        //String postResponse = example.doPostRequest("https://pub.orcid.org/oauth/token", "APP-OFHD8T3N2AWQE7Z9", "5a099bc5-56d0-4ca5-815e-31363eb8732c");


        Gson gson = new Gson();
        HashMap a = gson.fromJson(getResponse, HashMap.class);
        System.out.println(a);
    }
}