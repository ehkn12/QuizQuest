package com.example.GroupAssignment.AsyncTask;

import android.os.AsyncTask;

import com.example.GroupAssignment.ResultsDatabase;
import com.example.GroupAssignment.models.Results;

public class ResultsRetrieveAsyncTask extends AsyncTask<String, Integer, Results> {

    private ResultsDatabase resultsDatabase;
    private ResultsAsyncTaskDelegate delegate;

    public void setResultsDatabase(ResultsDatabase resultsDatabase) {this.resultsDatabase = resultsDatabase;}
    public void setDelegate(ResultsAsyncTaskDelegate delegate) {this.delegate = delegate;}

    @Override
    protected Results doInBackground(String... strings) {
        return resultsDatabase.dndInfoDao().getResult(strings[0]);
    }
    protected void onPostExecute(Results results) {
        delegate.handleResultsReturned(results);
    }
}
