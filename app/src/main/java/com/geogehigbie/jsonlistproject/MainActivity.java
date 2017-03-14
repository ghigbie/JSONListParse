package com.geogehigbie.jsonlistproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        makeVolleyRequest();

    }

    public void makeVolleyRequest(){
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, URL_BASE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.v("TAG ", response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject person = response.getJSONObject(i);
                        String name = person.getString("name");
                        Log.d(TAG, "onResponse: NAME " + name);
                        JSONObject phones = person.getJSONObject("phone");
                        String mobile = phones.getString("mobile");
                        Log.d(TAG, "onResponse: MOBILE " + mobile);

                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
}
