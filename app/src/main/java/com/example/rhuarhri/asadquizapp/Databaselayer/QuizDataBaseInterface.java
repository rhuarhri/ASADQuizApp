package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.List;
import java.util.Map;

public interface QuizDataBaseInterface {

    /*
    Facade interface for saving a retrieving data about quizzes
    effects the QuizDataBase, QuestionDataBase, RunQuizDB classes
     */

    void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion, Context context) throws Exception;

    void getAllQuizzes(final RecyclerView QuizRV) throws Exception;

    List<question> getAllQuestions(String quizDocumentId) throws Exception;

    String getQuizDocumentID(boolean newToDataBase, String QuizName);

    void getQuestion();

    void checkAnswer(String answer);


}
