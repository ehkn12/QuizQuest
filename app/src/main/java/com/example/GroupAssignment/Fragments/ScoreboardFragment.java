package com.example.GroupAssignment.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.Adapters.ScoreboardRecyclerAdapter;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.Activities.QuizActivity;

import java.util.ArrayList;


public class ScoreboardFragment extends Fragment {
    private QuizActivity qa;
    private RecyclerView.LayoutManager scoreBoardLayoutManager;
    private RecyclerView.Adapter scoreBoardAdapter;

    private ArrayList<Integer> scoreArrayList;



    public ScoreboardFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scoreboard, container, false);

        scoreArrayList = qa.getScoreHistory();
        // This toast is to make sure that the scoreArrayList actually contains something, otherwise we'll have to use static stuff
        // If it works uncomment the stuff below the Toast, as that sets up the recyclerView
        Toast.makeText(rootView.getContext(), Integer.toString(scoreArrayList.size()), Toast.LENGTH_LONG).show();

/*        RecyclerView scoreBoardRecycler = rootView.findViewById(R.id.scoreBoardRecyclerView);

        scoreBoardLayoutManager = new LinearLayoutManager(rootView.getContext());
        scoreBoardRecycler.setLayoutManager(scoreBoardLayoutManager);

        scoreBoardAdapter = new ScoreboardRecyclerAdapter(scoreArrayList);
        scoreBoardRecycler.setAdapter(scoreBoardAdapter);*/



        return rootView;
    }

}
