package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuestionDataBase;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.HashMap;
import java.util.Map;

public class QuestionManger implements QuizMangerInterface{

    String QuizName = "";
    String Question = "";
    String AnswerA = "";
    String AnswerB = "";
    String AnswerC = "";
    String AnswerD = "";

    String RightAnswer = "";

    int time = 0;

    QuestionDataBase QuestionDB = new QuestionDataBase();

    public QuestionManger(String quizname)
    {
        QuizName = quizname;
    }


    private String checkForErrors(question checkQuestion)
    {
        if(checkQuestion.getQuestion() == "")
        {
            return "No question added";

        }

        if(checkQuestion.getAnswerA() == "")
        {
            return "No A choice added";

        }

        if(checkQuestion.getAnswerB() == "")
        {
            return "No B choice added";

        }

        if(checkQuestion.getAnswerC() == "")
        {
            return "No C choice added";

        }

        if(checkQuestion.getAnswerD() == "")
        {
            return "No D choice added";

        }

        if(checkQuestion.getRightAnswer() == "")
        {
            return "No Right answer Selected";

        }

        if(checkQuestion.getTime() == 0)
        {
            return "Question Time not added";
        }

        //no errors found
        return "";
    }

    @Override
    public String Update(quiz newQuiz, question newQuestion, Context context) {
        String error = checkForErrors(newQuestion);

        return error;
    }

    @Override
    public void DisplayExistingQuizzes(RecyclerView quizRV, boolean isLecturer, Context appContext) {
        //Not implemented here
    }

    @Override
    public void getQuiz(String name, boolean isLecturer, Context context) {
        //Not implemented here
    }


    @Override
    public String add(quiz newQuiz, question newQuestion, Context context) {
        String error = checkForErrors(newQuestion);

        if (error != "")
        {
            return error;
        }

        try {


            QuestionDB.Add(QuizName, null, newQuestion, context);


        }
        catch (Exception e)
        {
            System.out.print(e);
        }

        return error;
    }

    @Override
    public void DisplayQuestion() {
        //Not implemented here
    }

    @Override
    public void startQuestion() {
        //Not implemented here
    }

    @Override
    public void endQuestion(String answer) {
        //Not implemented here
    }




}
