package com.example.rhuarhri.asadquizapp.Logiclayer;

public interface QuizMangerInterface {

    void getExistingQuiz(String QuizName);

    void setQuizName(String QuizName);

    void setQuizDescription(String QuizDescription);

    String getQuizDocumentID();

    String addQuiz();

    String updateQuiz(String QuizName);
}
