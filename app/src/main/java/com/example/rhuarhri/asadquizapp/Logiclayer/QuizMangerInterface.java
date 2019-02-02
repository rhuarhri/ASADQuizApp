package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

public interface QuizMangerInterface {

    String Update(quiz newQuiz, question newQuestion);

    void DisplayExistingQuiz(String name);

    //void setQuizName(String QuizName);

    //void setQuizDescription(String QuizDescription);

    String getQuizDocumentID();

    String add(quiz newQuiz, question newQuestion);


    void DisplayQuestion();

    //void setQuestion(String question);



    //void setAnswerA(String answer, boolean isRightAnswer);

    //String getAnswerA();

    //void setAnswerB(String answer, boolean isRightAnswer);

    //String getAnswerB();

    //void setAnswerC(String answer, boolean isRightAnswer);

    //String getAnswerC();

    //void setAnswerD(String answer, boolean isRightAnswer);

    //String getAnswerD();

    //void setQuestionDisplayTime(int Time);

    //int getQuestionDisplayTime();

    //boolean checkIfAnswerCorrect(String id);

    //String saveQuestion();

    public void startQuestion();

    public void endQuestion();

}
