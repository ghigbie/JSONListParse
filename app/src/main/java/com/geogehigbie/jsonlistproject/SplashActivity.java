package com.geogehigbie.jsonlistproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by georgehigbie on 3/13/17.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}