package com.geogehigbie.jsonlistproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String URL_BASE = "https://s3.amazonaws.com/technical-challenge/Contacts_v2.json";
    private ArrayList<String> entries;
    private ArrayList<String> namesArrayList;
    private ArrayList<String> mobileArrayList;
    private final String TAG = "DEBUGGING";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void makeVolleyReqest(){

    }
}
