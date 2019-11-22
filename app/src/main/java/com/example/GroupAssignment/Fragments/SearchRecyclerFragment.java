package com.example.GroupAssignment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.GroupAssignment.Adapters.SearchAdapter;
import com.example.GroupAssignment.models.DndInfoOverview;
import com.example.GroupAssignment.models.Results;
import com.example.GroupAssignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchRecyclerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    //url used to call api
    private String url = "https://api.open5e.com/search/?text=";
    private ImageView search;
    private LinearLayoutManager layoutManager;

    private OnFragmentInteractionListener mListener;

    public SearchRecyclerFragment() {
        // Required empty public constructor
    }


    public static SearchRecyclerFragment newInstance(String param1, String param2) {
        SearchRecyclerFragment fragment = new SearchRecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_search);
        layoutManager = new LinearLayoutManager(view.getContext());

        final EditText searchText = view.findViewById(R.id.edit_text_search);
        search = view.findViewById(R.id.image_search);
        recyclerView.setLayoutManager(layoutManager);



        //sends request to api and displays recyclerview
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        String jsonString = response;
                        System.out.println(jsonString);

                        DndInfoOverview searchList = gson.fromJson(jsonString, DndInfoOverview.class);
                        ArrayList<Results> data = new ArrayList<>(Arrays.asList(searchList.getSpells()));
                        SearchAdapter searchAdapter = new SearchAdapter(data, getContext());
                        recyclerView.setAdapter(searchAdapter);

                    }

                };

                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("The request failed.");
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
                StringRequest stringRequest =
                        new StringRequest(Request.Method.GET, url + searchText.getText().toString(), responseListener, errorListener);
                requestQueue.add(stringRequest);

            }
        });





        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}