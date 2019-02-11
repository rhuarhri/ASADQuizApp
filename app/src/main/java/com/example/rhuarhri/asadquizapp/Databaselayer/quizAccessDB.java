package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {storedQuizId.class}, version = 1)
public abstract class quizAccessDB extends RoomDatabase {
    public abstract queryStoredQuizzes storedQuizzes();
}
