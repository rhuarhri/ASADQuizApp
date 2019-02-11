package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static java.nio.charset.CodingErrorAction.IGNORE;

@Dao
public interface queryStoredQuizzes {

    @Insert
    void add(storedQuizId newQuiz);

    @Query("SELECT * FROM storedQuizId")
    List<storedQuizId> getAll();

    @Delete
    void delete(storedQuizId oldQuiz);

}
