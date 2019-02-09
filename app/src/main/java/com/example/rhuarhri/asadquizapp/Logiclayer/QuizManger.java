package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;
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
    public void DisplayExistingQuiz(String name) {

    }

    @Override
    public String getQuizDocumentID() {

        return QuizDB.getQuizDocumentID(IsNewQuiz, name);


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
        if(checkQuiz.getName() == "")
        {
            return "Name not added";
        }

        if (checkQuiz.getDescription() == "")
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
