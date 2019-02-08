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

        RunningQuiz = new RunQuizDB();

        QuizID = quizID;
        QuestionTXT = questionTXT;
        AnswerATXT = answerATXT;
        AnswerBTXT = answerBTXT;
        AnswerCTXT = answerCTXT;
        AnswerDTXT = answerDTXT;

        RightAnswerTXT = rightAnswerTXT;

        TimerPB = timerPB;
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
        RunningQuiz.getQuestion(QuizID, QuestionTXT, AnswerATXT, AnswerBTXT, AnswerCTXT, AnswerDTXT, TimerPB);
    }

    @Override
    public void endQuestion(String answer)
    {
        RunningQuiz.checkAnswer(answer, QuizID, RightAnswerTXT);
        RunningQuiz.setNextQuestion();
        //start new question
        startQuestion();
    }


    @Override
    public void startQuestionTimer(int time, final ProgressBar timerPB)
    {

        long timeInMS = (time * 1000);

        timerPB.setMax((int) timeInMS);

        questionTimer = new CountDownTimer(timeInMS, 1000)
        {

            @Override
            public void onTick(long timeToFinish) {
                timerPB.setProgress((int) timeToFinish);
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    @Override
    public void stopQuestionTimer()
    {
        try {
            questionTimer.cancel();
        }
        catch(Exception e)
        {
            /*in case the question eds because the timer runs out
            and an error could occur if the timer s stop when it is already stopped
             */
        }
    }

}
