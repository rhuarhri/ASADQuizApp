package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

public interface QuizMangerInterface {

    String Update(quiz newQuiz, question newQuestion, Context context);

    void DisplayExistingQuizzes(RecyclerView quizRV, boolean isLecturer, Context appContext);


    void getQuiz(String name, boolean isLecturer, Context context);

    String add(quiz newQuiz, question newQuestion, Context context);


    void DisplayQuestion();


    public void startQuestion();

    public void endQuestion(String answer);



}
