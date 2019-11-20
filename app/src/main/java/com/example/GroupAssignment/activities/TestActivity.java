package com.example.GroupAssignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.GroupAssignment.AsyncTask.AsyncTaskDelegate;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.models.Results;

import java.util.List;


public class TestActivity extends AppCompatActivity implements AsyncTaskDelegate {
    private RecyclerView spellRecycler;
    private RecyclerView.LayoutManager spellLayoutManager;
    private RecyclerView.Adapter spellAdapter;

    private String spellURL;
    private String weaponURL;

    private List<Results> spellList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        spellRecycler = findViewById(R.id.testRecyclerView);

        spellURL = "Spells";
        weaponURL = "Weapons";

        spellLayoutManager = new LinearLayoutManager(getApplicationContext());
        spellRecycler.setLayoutManager(spellLayoutManager);

        setSpellRecycler();
        // setWeaponRecycler(); setClassRecycler(); etc etc

    }


    // TODO So uh basically this is like the example method for displaying the data from the API in a RecyclerView, this URL gets Weapon data
    //  and the RecyclerView is set to display the Name of each spell, we can extend that further to display more in depth spell Info
    //  onClick or something. At this point not sure how about how we want to layout the third tab;
    //  We can also load this info into a RoomDB first and then extract it later (idk)
    //  We can change the URL to get different data and also change the RecyclerViews or however we want to display the information

    // The base URL is https://api.open5e.com/. The endpoints will change depending on what we want to get.
    // Also check https://open5e.com/api-docs for potentially helpful stuff.

    public void setSpellRecycler() {


        final RequestQueue queue = Volley.newRequestQueue(TestActivity.this);

        String url = "https://api.open5e.com/spells/?format=json&limit=10000";

        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

/*                spellRecycler = findViewById(R.id.testRecyclerView);

                spellLayoutManager = new LinearLayoutManager(getApplicationContext());
                spellRecycler.setLayoutManager(spellLayoutManager);
                Gson gson = new Gson();

                DndInfoOverview dndInfoOverview= gson.fromJson(response, DndInfoOverview.class);
                Results[] spells = dndInfoOverview.getSpells();
                spellList = Arrays.asList(spells);

                spellAdapter = new InfoNameRecyclerAdapter(spellList);
                spellRecycler.setAdapter(spellAdapter);*/

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("The request failed.");
            }
        };

        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url, responseListener, errorListener);

        queue.add(stringRequest);
    }


}
