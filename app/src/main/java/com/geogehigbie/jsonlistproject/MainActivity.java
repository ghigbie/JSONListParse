package com.geogehigbie.jsonlistproject;

import android.app.ActionBar;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    private final String URL_BASE = "https://s3.amazonaws.com/technical-challenge/Contacts_v2.json";
    private ArrayList<Person> peopleSimpleArrayList = new ArrayList<>();
    private ArrayList<String> namesArrayList = new ArrayList<>();
    private ArrayList<String> homePhoneArrayList = new ArrayList<>();
    private final String TAG = "DEBUGGING";
    private SoundPool soundPool;
    private int soundClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        centerActionBar();
        defineSoundPool();
        setButtonListener();
        makeVolleyRequest();

    }

    public void centerActionBar() {
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //this is a soft error
        getSupportActionBar().setCustomView(R.layout.action_bar);

    }

    public void makeVolleyRequest() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, URL_BASE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.v("TAG ", response.toString());
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject person = response.getJSONObject(i);
                            String name = person.getString("name");
                            Log.d(TAG, "onResponse: NAME " + name);
                            JSONObject phones = person.getJSONObject("phone");
                            String homePhone = phones.getString("home");
                            Log.d(TAG, "onResponse: HOME " + homePhone);

                            Person personObject = new Person(name, homePhone);
                            peopleSimpleArrayList.add(personObject);
                            namesArrayList.add(name);
                            homePhoneArrayList.add(homePhone);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
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


    public void createListView(){
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namesArrayList);
//        String [] namesArray = (String[]) namesArrayList.toArray();
        CustomListAdapter listAdapter = new CustomListAdapter(this, peopleSimpleArrayList);

        ListView listView = (ListView) findViewById(R.id.contacts_list);
        listView.setAdapter(listAdapter);
        listView.setVisibility(View.VISIBLE);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        showContactDetails();
                    }
                });

    }

    public void defineSoundPool() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        soundClick = soundPool.load(this, R.raw.click_on_sound, 1);

    }

    public void setButtonListener(){
        final Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(soundClick, 1, 1, 1, 0, 1);
                button.setVisibility(GONE);

                createListView();
            }
        });
    }

    public void showContactDetails(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new ContactDetail());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




}
