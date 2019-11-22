package com.example.GroupAssignment.AsyncTask;

import com.example.GroupAssignment.models.Question;

public interface QuestionAsyncTaskDelegate {

    void handleQuestionReturned(Question question);
}
