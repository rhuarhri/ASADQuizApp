package com.example.rhuarhri.asadquizapp.Databaselayer;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.List;
import java.util.Map;

public interface QuizDataBaseInterface {

    //boolean Add(Map<String, Object> quiz);

    void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) throws Exception;

    List<quiz> getAllQuizzes() throws Exception;

    List<question> getAllQuestions(String quizDocumentId) throws Exception;

    String getQuizDocumentID(boolean newToDataBase, String QuizName);


}
