package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

public interface QuizMangerInterface {

    String Update(quiz newQuiz, question newQuestion, Context context);

    void DisplayExistingQuiz(String name);


    String getQuizDocumentID();

    String add(quiz newQuiz, question newQuestion, Context context);


    void DisplayQuestion();


    public void startQuestion();

    public void endQuestion(String answer);



}
