package com.example.GroupAssignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.GroupAssignment.models.Results;

@Database(entities = {Results.class}, version = 1)
public abstract class ResultsDatabase extends RoomDatabase {
    public abstract DndInfoDao dndInfoDao();

    private static ResultsDatabase instance;
    public static ResultsDatabase getInstance(Context context){

        if(instance == null){
            //TODO:: to be changed with what we learn in class in this upcoming week
            instance = Room.databaseBuilder(context, ResultsDatabase.class, "infoDB").build();
        }
        return instance;
    }

}
