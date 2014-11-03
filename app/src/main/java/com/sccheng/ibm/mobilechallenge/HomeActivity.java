package com.sccheng.ibm.mobilechallenge;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomeActivity extends Activity {

    private static final String CLASS_NAME = HomeActivity.class.getSimpleName();
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        intro = (TextView) findViewById(R.id.introduction);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getIP(View v) {

        try {
            URL url = new URL("http://mobilechallenge.mybluemix.net/api/ip");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            readStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHeaders(View v) {

        try {
            URL url = new URL("http://mobilechallenge.mybluemix.net/api/headers");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            readStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDateTime(View v) {

        try {
            URL url = new URL("http://mobilechallenge.mybluemix.net/api/datetime");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            readStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getEcho(View v) {

        try {
            URL url = new URL("http://mobilechallenge.mybluemix.net/api/echo");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            readStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getValidate(View v) {

        try {
            URL url = new URL("http://mobilechallenge.mybluemix.net/api/validate");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            readStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readStream(InputStream in) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                intro.setText(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public void onClick(View v) {
//        new
//    }
//
//    public void getIP(View v) {
//
//
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet("http://mobilechallenge.mybluemix.net/api/ip");
//
//        HttpResponse httpResponse;
//        try{
//            httpResponse = httpClient.execute(httpGet);
//            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//
//
//
//            StringBuffer result = new StringBuffer();
//            String line = "";
//
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//
//            Log.d(CLASS_NAME, line);
//
//        } catch (ClientProtocolException e) {
//            Log.e(CLASS_NAME, "ClientProtocolException caught.", e);
//            e.printStackTrace();
//        } catch (IOException e) {
//            Log.e(CLASS_NAME, "IOException caught.", e);
//            e.printStackTrace();
//        }
//    }


}
