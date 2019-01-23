package com.example.rhuarhri.asadquizapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.rhuarhri.asadquizapp.Databaselayer.UserDatabase;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuestionManger;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Acceptance plan for the advanced analysis and design module app
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.rhuarhri.asadquizapp", appContext.getPackageName());
    }

    @Test
    public void checkIsUser()
    {
        boolean result = false;

        String name = "dave";
        String password = "123";

        UserDatabase UDTest = new UserDatabase();

        try {
            result = UDTest.checkUser(name, password);
        }
        catch(Exception e)
        {
            result = false;
        }

        assertEquals(result, true);
    }

    @Test
    public void addUser()
    {

    }

    @Test
    public void addQuiz()
    {
        String QuizName = "";
        String QuizDescription = "";

    }

    @Test
    public void addQuestion()
    {
        String QuizID= "";
        String Question = "Which logic gate only return 1 if both inputs are 1?";
        String AnswerA = "And";
        String AnswerB = "OR";
        String AnswerC = "XOR";
        String AnswerD = "NOT";
        int questionDisplayTime = 60;

        String error = "";

        QuestionManger QM = new QuestionManger(QuizID);

        QM.setQuestion(Question);

        QM.setAnswerA(AnswerA, true);
        QM.setAnswerB(AnswerB, false);
        QM.setAnswerC(AnswerC, false);
        QM.setAnswerD(AnswerD, false);
        QM.setQuestionDisplayTime(questionDisplayTime);

        try {
            error = QM.saveQuestion();

        }
        catch(Exception e)
        {
            error = "failed to save";
        }
        assertEquals(error, "");

    }

    @Test
    public void answerQuizCorrectly()
    {

    }

    @Test
    public void answerQuizInCorrectly()
    {

    }

    @Test
    public void findQuiz()
    {

    }

    /*add various other tests about the lecture running the quiz
    and the students getting results
     */
}
