package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class storedQuizId {

    @PrimaryKey
    String quizId;

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }
}
