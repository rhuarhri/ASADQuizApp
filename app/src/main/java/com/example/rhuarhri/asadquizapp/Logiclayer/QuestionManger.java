package com.example.rhuarhri.asadquizapp.Logiclayer;

import java.util.HashMap;
import java.util.Map;

public class QuestionManger implements QuestionMangerInterface{

    String Question = "";
    String AnswerA = "";
    String AnswerB = "";
    String AnswerC = "";
    String AnswerD = "";

    String RightAnswer = "";

    int time = 0;


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
    public String saveQuestion() {

        String error = "";

        if(Question == "")
        {
            error = "No question added";
            return error;
        }

        if(AnswerA == "")
        {
            error = "No A choice added";
            return error;
        }

        if(AnswerB == "")
        {
            error = "No B choice added";
            return error;
        }

        if(AnswerC == "")
        {
            error = "No C choice added";
            return error;
        }

        if(AnswerD == "")
        {
            error = "No D choice added";
            return error;
        }

        if(RightAnswer == "")
        {
            error = "No Right answer Selected";
            return error;
        }

        if(time == 0)
        {
            error = "Question Time not added";
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

        //TODO Add map to data base

        return error;
    }
}
