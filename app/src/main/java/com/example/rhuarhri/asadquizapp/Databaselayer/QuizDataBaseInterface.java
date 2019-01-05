package com.example.rhuarhri.asadquizapp.Databaselayer;

import java.util.Map;

public interface QuizDataBaseInterface {

    //boolean Add(Map<String, Object> quiz);

    boolean Add(String quizDocumentId, Map<String, Object> data);

    String getQuizDocumentID(boolean newToDataBase, String QuizName);


}
