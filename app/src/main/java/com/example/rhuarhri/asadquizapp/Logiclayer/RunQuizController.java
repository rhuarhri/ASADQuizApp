package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.RunQuizDB;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

public class RunQuizController implements QuizMangerInterface {

    CountDownTimer questionTimer;
    String QuizID = "";

    TextView QuestionTXT;
    TextView AnswerATXT;
    TextView AnswerBTXT;
    TextView AnswerCTXT;
    TextView AnswerDTXT;

    TextView RightAnswerTXT;

    ProgressBar TimerPB;

    RunQuizDB RunningQuiz;

    public RunQuizController()
    {

    }

    public RunQuizController(String quizID, TextView questionTXT, TextView answerATXT, TextView answerBTXT, TextView answerCTXT, TextView answerDTXT, ProgressBar timerPB, TextView rightAnswerTXT)
    {

        RunningQuiz = new RunQuizDB(quizID, questionTXT, answerATXT, answerBTXT,
                answerCTXT, answerDTXT, timerPB, rightAnswerTXT);


    }

    @Override
    public String Update(quiz newQuiz, question newQuestion, Context context) {
        //Not implemented here
        return null;
    }

    @Override
    public void DisplayExistingQuiz(String name) {
        //Not implemented here
    }

    @Override
    public String getQuizDocumentID() {
        //Not implemented here
        return null;
    }

    @Override
    public String add(quiz newQuiz, question newQuestion, Context context) {
        //Not implemented here
        return null;
    }

    @Override
    public void DisplayQuestion() {
        //Not implemented here
    }

    @Override
    public void startQuestion()
    {
        RunningQuiz.getQuestion();
    }

    @Override
    public void endQuestion(String answer)
    {
        RunningQuiz.checkAnswer(answer);

    }



}
