package com.example.GroupAssignment.AsyncTask;

import android.os.AsyncTask;

import com.example.GroupAssignment.ResultsDatabase;
import com.example.GroupAssignment.models.Results;

import java.util.List;

public class ResultInsertAsyncTask extends AsyncTask<List<Results>, Integer, String> {

    private ResultsDatabase resultsDatabase;
    private ResultsAsyncTaskDelegate delegate;

    public void setResultsDatabase(ResultsDatabase resultsDatabase) {this.resultsDatabase = resultsDatabase;}
    public void setDelegate(ResultsAsyncTaskDelegate delegate) {this.delegate = delegate;}

    @Override
    protected String doInBackground(List<Results>... lists) {
        resultsDatabase.dndInfoDao().insertAllResults(lists[0]);
        return null;
    }

}
