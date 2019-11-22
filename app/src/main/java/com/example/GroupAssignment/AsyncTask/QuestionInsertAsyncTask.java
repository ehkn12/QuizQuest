package com.example.GroupAssignment.AsyncTask;

import android.os.AsyncTask;

import com.example.GroupAssignment.QuestionDatabase;
import com.example.GroupAssignment.models.Question;

import java.util.List;

public class QuestionInsertAsyncTask extends AsyncTask<List<Question>, Integer, String> {

    private QuestionAsyncTaskDelegate delegate;
    private QuestionDatabase questionDatabase;

    public void setDelegate(QuestionAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setQuestionDatabase(QuestionDatabase questionDatabase) {this.questionDatabase = questionDatabase;}

    @Override
    protected String doInBackground(List<Question>... lists) {
        questionDatabase.questionDao().insertAll(lists[0]);
        return null;
    }

}
