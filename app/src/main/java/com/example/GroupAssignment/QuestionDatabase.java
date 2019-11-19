package com.example.GroupAssignment;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.GroupAssignment.Models.Question;

@Database(entities = {Question.class}, version = 1)
public abstract class QuestionDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();

    private static QuestionDatabase instance;
    public static QuestionDatabase getInstance(Context context){

        if(instance == null){
            //TODO:: to be changed with what we learn in class in this upcoming week
            instance = Room.databaseBuilder(context, QuestionDatabase.class, "questDB").allowMainThreadQueries().build();
        }
        return instance;
    }

}
