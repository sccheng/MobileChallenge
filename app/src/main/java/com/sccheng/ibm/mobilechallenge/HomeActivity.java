package com.sccheng.ibm.mobilechallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {

    public static final String SERVICE_NAME = "com.sccheng.ibm.mobilechallenge.service";
    public static final String BUTTON_NAME = "com.sccheng.ibm.mobilechallenge.button";
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
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        String service = "";
        Button button = new Button(this);
        switch(v.getId()) {
            case R.id.ip:
                service = "ip";
                button = (Button)findViewById(R.id.ip);
                break;
            case R.id.headers:
                service = "headers";
                button = (Button)findViewById(R.id.headers);
                break;
            case R.id.datetime:
                service = "datetime";
                button = (Button)findViewById(R.id.datetime);
                break;
            case R.id.echo:
                service = "echo";
                button = (Button)findViewById(R.id.echo);
                break;
            case R.id.validate:
                service = "validate";
                button = (Button)findViewById(R.id.validate);
                break;
        }
        String buttonText;
        buttonText = (String) button.getText();

        if(service.equals("echo") || service.equals("validate")) {
            Intent intent = new Intent(this, MoreDetails.class);
            intent.putExtra(SERVICE_NAME, service);
            intent.putExtra(BUTTON_NAME, buttonText);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, Details.class);
            intent.putExtra(SERVICE_NAME, service);
            intent.putExtra(BUTTON_NAME, buttonText);
            startActivity(intent);
        }
    }

}
