package com.example.rhuarhri.asadquizapp.Logiclayer;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.HashMap;
import java.util.Map;

public class QuizManger implements  QuizMangerInterface{

    String name = "";
    String description = "";
    boolean newQuiz = false;
    QuizDataBase QuizDB = new QuizDataBase();


    @Override
    public void getExistingQuiz(String QuizName) {
        newQuiz = false;
        //TODO add code to get quiz from data base
    }

    @Override
    public void setQuizName(String QuizName) {
        name = QuizName;
    }

    @Override
    public void setQuizDescription(String QuizDescription) {
        description = QuizDescription;
    }

    @Override
    public String getQuizDocumentID() {

        return QuizDB.getQuizDocumentID(newQuiz, name);


    }

    @Override
    public String addQuiz() {

        String Error = checkForErrors();

        if(Error != "")
        {
            return Error;
        }

       quiz newQuiz = new quiz(name, description);


        if (QuizDB.Add("", newQuiz, null) == true)
        {
            //successfully added quiz
        }
        else
        {
            Error = "failed to add quiz";
        }

        return Error;
    }

    @Override
    public String updateQuiz(String QuizName) {
        String Error = checkForErrors();

        if(Error != "")
        {
            return Error;
        }

        return Error;
    }


    private String checkForErrors()
    {
        if(name == "")
        {
            return "Name not added";
        }

        if (description == "")
        {
            return "Description not added";
        }

        //checks if quiz name is already used
        if(QuizDB.getQuizDocumentID(false, name) == "")
        {
            //name not found in data base
        }
        else
        {
            return "Quiz name already exists";
        }

        //no errors found
        return "";
    }

}
