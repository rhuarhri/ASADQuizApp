package com.example.rhuarhri.asadquizapp.Databaselayer;

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

    void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) throws Exception;

    void getAllQuizzes(final RecyclerView QuizRV) throws Exception;

    List<question> getAllQuestions(String quizDocumentId) throws Exception;

    String getQuizDocumentID(boolean newToDataBase, String QuizName);

    void getQuestion(String QuizID, final TextView questionTXT, final TextView answerATXT, final TextView answerBTXT, final TextView answerCTXT, final TextView answerDTXT, final ProgressBar TimerPB);

    void checkAnswer(String answer, String QuizID, TextView rightAnswerTXT);


}
