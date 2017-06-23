package com.example.karthik.httpservic;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by karthik on 6/23/2017.
 */

public class SignupActivity extends AsyncTask<String, Void, String> {

    private Context context;

    public SignupActivity(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {
        String fullName = arg0[0];
        String userName = arg0[1];
        String passWord = arg0[2];
        String phoneNumber = arg0[3];
        String emailAddress = arg0[4];

        String link;
        String data;
        BufferedReader bufferedReader;
        String result;

        try {
            data = "?fullname=" + URLEncoder.encode(fullName, "UTF-8");
            data += "&username=" + URLEncoder.encode(userName, "UTF-8");
            data += "&password=" + URLEncoder.encode(passWord, "UTF-8");
            data += "&phonenumber=" + URLEncoder.encode(phoneNumber, "UTF-8");
            data += "&emailaddress=" + URLEncoder.encode(emailAddress, "UTF-8");

            link = "http://www.fratelloinnotech.com/signup.php" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();

            return result;

        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();

    }
}

