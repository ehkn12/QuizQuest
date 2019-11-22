package com.example.GroupAssignment.AsyncTask;

// TODO At the end when we convert DB requests to AsyncTask we'll fill this and other AsyncTasks out

import android.os.AsyncTask;

import com.example.GroupAssignment.QuestionDatabase;
import com.example.GroupAssignment.models.Question;

public class QuestionRetrieveAsyncTask extends AsyncTask<Integer, Integer, Question> {

    private QuestionAsyncTaskDelegate delegate;
    private QuestionDatabase questionDatabase;

    public void setDelegate(QuestionAsyncTaskDelegate delegate) {this.delegate = delegate;}
    public void setQuestionDatabase(QuestionDatabase questionDatabase) {this.questionDatabase = questionDatabase;}


    @Override
    protected Question doInBackground(Integer... integers) {

        return questionDatabase.questionDao().getQuestion(integers[0]);
    }

    protected void onPostExecute(Question question) {
        delegate.handleQuestionReturned(question);
    }
}
