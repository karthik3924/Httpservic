package com.example.karthik.httpservic;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {
    EditText fname,uname,pass,pno,email;
    TextView etxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname= (EditText) findViewById(R.id.fullname);
        uname= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        pno= (EditText) findViewById(R.id.Phonenumber);
        email= (EditText) findViewById(R.id.email);

        etxt=(TextView) findViewById(R.id.etxt);
    }
    public void signup(View v) {
        String fn=fname.getText().toString();
        String un=uname.getText().toString();
        String pd=pass.getText().toString();
        String pn=pno.getText().toString();
        String em=email.getText().toString();

        Toast.makeText(this, "Signing up...", Toast.LENGTH_SHORT).show();
        new SignupActivity(this).execute(fn, un, pd, pn, em);
    }

    public void getJsonData(View view)
    {
        Toast.makeText(getApplicationContext(),"getdata",Toast.LENGTH_LONG).show();
        Intent jsondata = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(jsondata);
    }

}

