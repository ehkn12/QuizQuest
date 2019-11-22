package com.example.GroupAssignment.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.GroupAssignment.Adapters.InfoNameRecyclerAdapter;
import com.example.GroupAssignment.AsyncTask.ResultInsertAsyncTask;
import com.example.GroupAssignment.AsyncTask.ResultsAsyncTaskDelegate;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.ResultsDatabase;
import com.example.GroupAssignment.models.*;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoNameFragment extends Fragment implements ResultsAsyncTaskDelegate {

    private InfoNameFragment infoNameFragment = this;

    private RecyclerView infoNameRecycler;
    private RecyclerView.LayoutManager infoNameLayoutManager;
    private RecyclerView.Adapter infoNameAdapter;

    private ResultsDatabase rdb;

    private String infoType;
    private String searchUrl;

    private List<Results> resultsList;


    public InfoNameFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_info_name, container, false);

        Bundle bundle = this.getArguments();
        infoType = bundle.getString("infoType");

        switch (infoType)
        {
            case "Spells":
                searchUrl = "https://api.open5e.com/spells/?format=json&limit=10000";
                break;

            case "Weapons":
                searchUrl = "https://api.open5e.com/weapons/?format=json";
                break;

            case "Classes":
                searchUrl = "https://api.open5e.com/classes/?format=json";
                break;

            //to be googled classes
            case "Backgrounds":
                searchUrl = "https://api.open5e.com/backgrounds/?limit=10";
                break;

            case "Planes":
                searchUrl = "https://api.open5e.com/planes/";
                break;

            case "Races":
                searchUrl = "https://api.open5e.com/races/";
                break;

            case "Sections":
                searchUrl = "https://api.open5e.com/sections/?limit=10";
                break;

            case "Conditions":
                searchUrl = "https://api.open5e.com/conditions/?limit=10";
                break;

            case "Magic Items":
                searchUrl = "https://api.open5e.com/magicitems/?limit=10";
                break;

        }

        setInfoRecycler(view, searchUrl, infoType);

        return view;
    }



    public void setInfoRecycler(final View view, String searchUrl, final String infoType) {

        final RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = searchUrl;

        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                rdb = ResultsDatabase.getInstance(view.getContext());

                infoNameRecycler = view.findViewById(R.id.infoNameRecyclerView);

                infoNameLayoutManager = new LinearLayoutManager(view.getContext());
                infoNameRecycler.setLayoutManager(infoNameLayoutManager);

                Gson gson = new Gson();

                DndInfoOverview dndInfoOverview = gson.fromJson(response, DndInfoOverview.class);
                Results[] results = dndInfoOverview.getSpells();
                resultsList = Arrays.asList(results);

                if(infoType == "Spells" || infoType == "Weapons" || infoType == "Classes"){
                    insertResultsIntoDb(resultsList, rdb);
                }

                infoNameAdapter = new InfoNameRecyclerAdapter(resultsList, infoType, view.getContext());
                infoNameRecycler.setAdapter(infoNameAdapter);

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

    public void insertResultsIntoDb(List<Results> resultsList, ResultsDatabase resultsDatabase) {
        ResultInsertAsyncTask resultInsertAsyncTask = new ResultInsertAsyncTask();
        resultInsertAsyncTask.setResultsDatabase(resultsDatabase);
        resultInsertAsyncTask.setDelegate(infoNameFragment);
        resultInsertAsyncTask.execute(resultsList);
    }


    @Override
    public void handleResultsReturned(Results results) {

    }
}
