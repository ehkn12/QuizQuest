package com.example.GroupAssignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.GroupAssignment.models.Question;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Question> question);

    @Update
    public void update(Question... questions);

    @Delete
    public void delete(Question question);

    @Query("SELECT * FROM question")
    List<Question> getAllBooks();

    @Query("SELECT * FROM question WHERE id = :number")
    public Question getQuestion(int number);
}
