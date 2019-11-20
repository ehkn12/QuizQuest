package com.example.GroupAssignment.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.R;
import com.example.GroupAssignment.activities.QuizActivity;

public class QuizFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView startQuiz;

//    QuizAdapter quizAdapter = new QuizAdapter();

    public QuizFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        startQuiz = view.findViewById(R.id.quiz_image_start);
        startQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context c = v.getContext();
                Intent intent = new Intent(c, QuizActivity.class);
                c.startActivity(intent);
            }
        });

        return view;
    }

}
