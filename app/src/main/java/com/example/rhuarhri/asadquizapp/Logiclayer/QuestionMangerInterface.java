package com.example.rhuarhri.asadquizapp.Logiclayer;

public interface QuestionMangerInterface {

    void setQuestion(String question);

    String getQuestion();

    void setAnswerA(String answer, boolean isRightAnswer);

    String getAnswerA();

    void setAnswerB(String answer, boolean isRightAnswer);

    String getAnswerB();

    void setAnswerC(String answer, boolean isRightAnswer);

    String getAnswerC();

    void setAnswerD(String answer, boolean isRightAnswer);

    String getAnswerD();

    void setQuestionDisplayTime(int Time);

    int getQuestionDisplayTime();

    boolean checkIfAnswerCorrect(String id);

    String saveQuestion();
}
