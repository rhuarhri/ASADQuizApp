package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {storedQuizId.class}, version = 1)
public abstract class quizAccessDB extends RoomDatabase {


    public abstract queryStoredQuizzes storedQuizzes();


}
