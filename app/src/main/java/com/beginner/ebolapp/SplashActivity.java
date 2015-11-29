package com.beginner.ebolapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Parse.initialize(this, "H1AruCUvoF6jVvanogGDu5p4flZLAgfP17g075nD", "mICIB0VVU7pLIqfr2sYxLHd87MjToCQw56DNng9r");



        Runnable runnable3Secs = new Runnable() {
            @Override
            public void run() {
                nextActivity();
                finish();
            }
        };

        Handler myHandler = new Handler();
        myHandler.postDelayed(runnable3Secs, 3000);
    }

    

    public void nextActivity(){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}
