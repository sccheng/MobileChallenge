package com.sccheng.ibm.mobilechallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MoreDetails extends Activity {

    private String service = "";
    TextView textView;
    EditText tempKey;
    EditText tempValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        Intent intent = getIntent();
        service = intent.getStringExtra(HomeActivity.SERVICE_NAME);

        String buttonName = intent.getStringExtra(HomeActivity.BUTTON_NAME);
        Button button;
        button = (Button)findViewById(R.id.runServiceInput);
        button.setText(buttonName);

        textView = (TextView)findViewById(R.id.displayMoreResults);


        tempKey  = (EditText)findViewById(R.id.key1);
        tempValue  = (EditText)findViewById(R.id.value1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void callServiceInput(View v) {
        try {
            URL url;
            String urlString = "http://mobilechallenge.mybluemix.net/api/" + service;
            if(service.equals("echo")) {
                urlString += "/";
                urlString += tempKey.getText();
                urlString += "/" + tempValue.getText();
                tempKey.setText("");
                tempValue.setText("");
            }
            url = new URL(urlString);

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
                textView.setText(line);
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
}
