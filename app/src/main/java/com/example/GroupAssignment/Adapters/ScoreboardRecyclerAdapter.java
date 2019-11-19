package com.example.GroupAssignment.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.GroupAssignment.R;

import java.util.ArrayList;

public class ScoreboardRecyclerAdapter extends RecyclerView.Adapter<ScoreboardRecyclerAdapter.ScoreboardViewHolder> {

    public ArrayList<Integer> scoreArrayList;

    public static class ScoreboardViewHolder extends RecyclerView.ViewHolder {
        public TextView score;
        public ScoreboardViewHolder(@NonNull View itemView) {
            super(itemView);
            score = itemView.findViewById(
                    R.id.scoreTextView);


        }
    }

    public ScoreboardRecyclerAdapter(ArrayList<Integer> scoreList) {
        scoreArrayList = scoreList;
    }

    @NonNull
    @Override
    public ScoreboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scoreboardlayout, parent, false);
        ScoreboardViewHolder scoreboardViewHolder = new ScoreboardViewHolder(view);
        return scoreboardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreboardViewHolder holder, int position) {
        holder.score.setText(Integer.toString(scoreArrayList.get(position)));
    }


    @Override
    public int getItemCount() {
        return scoreArrayList.size();
    }
}


