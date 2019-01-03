package com.example.rhuarhri.asadquizapp.Databaselayer;

import java.util.Map;

public interface QuizDataBaseInterface {

    boolean AddQuiz(Map<String, Object> quiz);

    boolean AddQuestion(String quizDocumentId, Map<String, Object> question);

    String getQuizDocumentID(boolean newToDataBase, String QuizName);


}
