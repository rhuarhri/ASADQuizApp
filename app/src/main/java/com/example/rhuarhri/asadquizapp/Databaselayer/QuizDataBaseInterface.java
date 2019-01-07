package com.example.rhuarhri.asadquizapp.Databaselayer;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.List;
import java.util.Map;

public interface QuizDataBaseInterface {

    //boolean Add(Map<String, Object> quiz);

    boolean Add(String quizDocumentId, quiz AddQuiz, question AddQuestion);

    List<quiz> getAllQuizzes();

    List<question> getAllQuestions();

    String getQuizDocumentID(boolean newToDataBase, String QuizName);


}
