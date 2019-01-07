package com.example.rhuarhri.asadquizapp.customDataTypes;

public class question {

    private String question;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private String RightAnswer;
    private int time;

    public  question(String Question, String answerA, String answerB, String answerC, String answerD, String rightAnswer, int Time)
    {
        question = Question;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        RightAnswer = rightAnswer;
        time = Time;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public int getTime() {
        return time;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public void setRightAnswer(String rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
