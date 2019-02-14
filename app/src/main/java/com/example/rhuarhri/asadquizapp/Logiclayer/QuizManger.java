package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.CreateQuizActivity;
import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;
import com.example.rhuarhri.asadquizapp.Databaselayer.studentQuizzes;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.HashMap;
import java.util.Map;

public class QuizManger implements  QuizMangerInterface{

    String name = "";
    String description = "";
    boolean IsNewQuiz = false;
    QuizDataBase QuizDB = new QuizDataBase();

/*
    @Override
    public void getExistingQuiz(String QuizName) {
        newQuiz = false;
        //TODO add code to get quiz from data base
    }*/




    @Override
    public void DisplayExistingQuizzes(RecyclerView quizRV, boolean isLecturer, Context appContext) {


        QuizDataBase QuizBD = new QuizDataBase();

        if (isLecturer == true)
        {
            try {
                QuizBD.getAllQuizzes(null, quizRV, true, appContext);
            }
            catch(Exception e)
            {

            }
        }
        else
        {
            studentQuizzes getQuizzes = new studentQuizzes();
            try {
                QuizBD.getAllQuizzes(getQuizzes.getAllStudentsQuizzes(appContext), quizRV, false, appContext);
            }
            catch(Exception e)
            {

            }
        }





    }

    @Override
    public void getQuiz(String name, boolean isLecturer, Context context) {

        QuizDB.getQuiz(name, isLecturer, context);


    }

    @Override
    public String add(quiz newQuiz, question newQuestion, Context context) {



        String Error = checkForErrors(newQuiz);

        if(Error != "")
        {
            return Error;
        }



        try {
            QuizDB.Add("", newQuiz, null, context);
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

        return Error;
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



    @Override
    public String Update(quiz newQuiz, question newQuestion, Context context) {

        IsNewQuiz = false;

        String Error = checkForErrors(newQuiz);

        if(Error != "")
        {
            return Error;
        }

        return Error;
    }


    private String checkForErrors(quiz checkQuiz)
    {
        if(checkQuiz.getName().equals("") || checkQuiz.getName().isEmpty())
        {

            return "Name not added";
        }

        if (checkQuiz.getDescription().equals("") || checkQuiz.getDescription().isEmpty())
        {
            return "Description not added";
        }

        /*
        //checks if quiz name is already used
        if(QuizDB.getQuizDocumentID(false, checkQuiz.getName()) == "")
        {
            //name not found in data base
        }
        else
        {
            return "Quiz name already exists";
        }*/

        //no errors found
        return "";
    }

}
