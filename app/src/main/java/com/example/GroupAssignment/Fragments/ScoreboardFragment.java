package com.example.GroupAssignment.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.Adapters.ScoreboardRecyclerAdapter;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.activities.QuizActivity;

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

        scoreArrayList = QuizActivity.getScoreHistory();


        RecyclerView scoreBoardRecycler = rootView.findViewById(R.id.scoreBoardRecyclerView);

        scoreBoardLayoutManager = new LinearLayoutManager(rootView.getContext());
        scoreBoardRecycler.setLayoutManager(scoreBoardLayoutManager);

        scoreBoardAdapter = new ScoreboardRecyclerAdapter(scoreArrayList);
        scoreBoardRecycler.setAdapter(scoreBoardAdapter);



        return rootView;
    }

}
