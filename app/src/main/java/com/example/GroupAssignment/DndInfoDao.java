package com.example.GroupAssignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.GroupAssignment.models.Results;

import java.util.List;

@Dao
public interface DndInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllResults(List<Results> resultsList);

    @Query("select * from results where name = :name")
    Results getResult(String name);




}
