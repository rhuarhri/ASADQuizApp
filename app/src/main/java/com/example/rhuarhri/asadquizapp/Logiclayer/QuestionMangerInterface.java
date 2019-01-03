package com.example.rhuarhri.asadquizapp.Logiclayer;

public interface QuestionMangerInterface {

    void setQuestion(String question);

    void setAnswerA(String answer, boolean isRightAnswer);

    void setAnswerB(String answer, boolean isRightAnswer);

    void setAnswerC(String answer, boolean isRightAnswer);

    void setAnswerD(String answer, boolean isRightAnswer);

    void setQuestionDisplayTime(int Time);

    boolean checkIfAnswerCorrect(String id);

    String saveQuestion();
}
