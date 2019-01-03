package com.example.rhuarhri.asadquizapp.Logiclayer;

import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuestionDataBase;

import java.util.HashMap;
import java.util.Map;

public class QuestionManger implements QuestionMangerInterface{

    String QuizName = "";
    String Question = "";
    String AnswerA = "";
    String AnswerB = "";
    String AnswerC = "";
    String AnswerD = "";

    String RightAnswer = "";

    int time = 0;

    QuestionDataBase QuestionDB = new QuestionDataBase();

    QuestionManger(String quizname)
    {
        QuizName = quizname;
    }

    @Override
    public void setQuestion(String question) {
        Question = question;
    }

    @Override
    public void setAnswerA(String answer, boolean isRightAnswer) {
        AnswerA = answer;
        if(isRightAnswer == true)
        {
            RightAnswer = "A";
        }
    }

    @Override
    public void setAnswerB(String answer, boolean isRightAnswer) {
        AnswerB = answer;
        if(isRightAnswer == true)
        {
            RightAnswer = "B";
        }
    }

    @Override
    public void setAnswerC(String answer, boolean isRightAnswer) {
        AnswerC = answer;
        if(isRightAnswer == true)
        {
            RightAnswer = "C";
        }
    }

    @Override
    public void setAnswerD(String answer, boolean isRightAnswer) {
        AnswerD = answer;
        if(isRightAnswer == true)
        {
            RightAnswer = "D";
        }
    }

    @Override
    public void setQuestionDisplayTime(int Time) {

        time = Time;

    }

    @Override
    public boolean checkIfAnswerCorrect(String id) {
        if(RightAnswer == id)
        {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public String saveQuestion() {

        String error = checkForErrors();

        if (error != "")
        {
            return error;
        }

        //no errors found

        Map<String, Object> newQuestion = new HashMap<>();
        newQuestion.put("question", Question);
        newQuestion.put("A", AnswerA);
        newQuestion.put("B", AnswerB);
        newQuestion.put("C", AnswerC);
        newQuestion.put("D", AnswerD);
        newQuestion.put("rightAnswer", RightAnswer);
        newQuestion.put("DisplayTime", time);



        if(QuestionDB.AddQuestion(QuizName, newQuestion) == true)
        {

        }
        else{
            error = "Failed to add to data base";
        }

        return error;
    }

    private String checkForErrors()
    {
        if(Question == "")
        {
            return "No question added";

        }

        if(AnswerA == "")
        {
            return "No A choice added";

        }

        if(AnswerB == "")
        {
            return "No B choice added";

        }

        if(AnswerC == "")
        {
            return "No C choice added";

        }

        if(AnswerD == "")
        {
            return "No D choice added";

        }

        if(RightAnswer == "")
        {
            return "No Right answer Selected";

        }

        if(time == 0)
        {
            return "Question Time not added";
        }

        //no errors found
        return "";
    }
}
