package com.example.rhuarhri.asadquizapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.UserDatabase;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuestionManger;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuizManger;
import com.example.rhuarhri.asadquizapp.Logiclayer.RunQuizController;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.example.rhuarhri.asadquizapp.customDataTypes.user;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.charset.Charset;
import java.util.Random;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Acceptance plan for the advanced analysis and design module app.
 * If a test does not specify that it has been implemented
 * should work with the supplied code.
 * You should be able to run the tests in android studio.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //auto generated keeping for reference
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.rhuarhri.asadquizapp", appContext.getPackageName());
    }
    //auto generated



    @Rule
    public ActivityTestRule<LoginActivity> LoginAct = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkIsLecture()
    {
        //boolean result = false;

        //fuzz testing which is introducing random data into tests
        /*
        This test creates a random password and name and uses them to try and access
        the app.
        It should fail all of the time, however their is the slim chance that it could generate the
        right name and password

         */

        byte[] randomByteData = new byte[7];

        //get random byte
        new Random().nextBytes(randomByteData);

        String name = new String(randomByteData, Charset.forName("UTF-8"));

        randomByteData = new byte[7];

        //get random byte
        new Random().nextBytes(randomByteData);

        String password = new String(randomByteData, Charset.forName("UTF-8"));

        String error = "";
        String expected = "";

        Espresso.onView(withId(R.id.UserNameET)).perform(typeText(name));
        Espresso.onView(withId(R.id.PasswordET)).perform(typeText(password));

        Espresso.onView(withId(R.id.TitleTXT)).check(matches(withText("not logged in")));
        /*
        This test will most likely fail as the did not wait for the result to come from the data base
        before checking
         */

    }

    @Test
    public void addLecture()
    {
        String name = "fred";
        String password = "567";

        String error = "";
        String expected = "";

        user testUser = new user(name, password);

        UserDatabase userAddDB = new UserDatabase();

        try {
            userAddDB.addUser(name, password);

        }
        catch(Exception e)
        {
            error = "failed to add";
        }

        assertEquals(expected, error);
    }

    /**
     * Editing a quiz
     */

    @Test
    public void addQuiz()
    {
        String QuizName = "Test name";
        String QuizDescription = "Test description";

        String error = "";
        String expected = "";

        QuizManger quizManger = new QuizManger();

        quiz newQuiz = new quiz();

        newQuiz.setName(QuizName);

        newQuiz.setDescription(QuizDescription);



        try {
            error = quizManger.add(newQuiz, null);

        }
        catch(Exception e)
        {
            error = "failed to save";
        }
        assertEquals(expected, error);



    }

    @Test
    public void addEmptyQuiz()
    {
        String QuizName = "";
        String QuizDescription = "";

        String error = "";
        String expected = "";

        QuizManger quizManger = new QuizManger();

        quiz newQuiz = new quiz();

        newQuiz.setName(QuizName);

        newQuiz.setDescription(QuizDescription);

        try {
            error = quizManger.add(newQuiz, null);

        }
        catch(Exception e)
        {
            error = "failed to save";
        }
        assertNotEquals(expected, error);

    }

    @Test
    public void updateExistingQuiz()
    {
        //not yet implemented
    }

    @Test
    public void updateQuizQuestion()
    {
        //not yet implemented
    }

    /**
     * Editing a question
     */

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
        String expected = "";

        QuestionManger QM = new QuestionManger(QuizID);

        question newQuestion = new question();

        newQuestion.setQuestion(Question);

        newQuestion.setAnswerA(AnswerA);
        newQuestion.setAnswerB(AnswerB);
        newQuestion.setAnswerC(AnswerC);
        newQuestion.setAnswerD(AnswerD);
        newQuestion.setTime(questionDisplayTime);

        newQuestion.setCorrectAnswer(true, false, false, false);



        try {
            error = QM.add(null, newQuestion);

        }
        catch(Exception e)
        {
            error = "failed to save";
        }
        assertEquals(expected, error);


    }

    @Test
    public void addEmptyQuestion()
    {
        String QuizID= "";
        String Question = "";
        String AnswerA = "";
        String AnswerB = "";
        String AnswerC = "";
        String AnswerD = "";
        int questionDisplayTime = 0;

        String error = "";
        String expected = "";

        QuestionManger QM = new QuestionManger(QuizID);

        question newQuestion = new question();

        newQuestion.setQuestion(Question);

        newQuestion.setAnswerA(AnswerA);
        newQuestion.setAnswerB(AnswerB);
        newQuestion.setAnswerC(AnswerC);
        newQuestion.setAnswerD(AnswerD);
        newQuestion.setTime(questionDisplayTime);

        newQuestion.setCorrectAnswer(true, false, false, false);



        try {
            error = QM.add(null, newQuestion);

        }
        catch(Exception e)
        {
            error = "failed to save";
        }

        //error found and question should not allowed to save
        assertNotEquals(expected, error);
        /*if error is "failed to save" then the app tried to save the data in
        the firebase data base which should not be allowed
         */
        expected = "failed to save";
        assertNotEquals(expected, error);

    }

    @Test
    public void addQuestionWithoutRightAnswerSelected()
    {
        String QuizID= "";
        String Question = "Which logic gate only return 1 if both inputs are 1?";
        String AnswerA = "And";
        String AnswerB = "OR";
        String AnswerC = "XOR";
        String AnswerD = "NOT";
        int questionDisplayTime = 60;

        String error = "";
        String expected = "";

        QuestionManger QM = new QuestionManger(QuizID);

        question newQuestion = new question();

        newQuestion.setQuestion(Question);

        newQuestion.setAnswerA(AnswerA);
        newQuestion.setAnswerB(AnswerB);
        newQuestion.setAnswerC(AnswerC);
        newQuestion.setAnswerD(AnswerD);
        newQuestion.setTime(questionDisplayTime);

        /* all questions set as wrong no right answer selected
        this might be a common thing that a user may forget to do
        */
        newQuestion.setCorrectAnswer(true, false, false, false);



        try {
            error = QM.add(null, newQuestion);

        }
        catch(Exception e)
        {
            error = "failed to save";
        }

        //error found and question should not allowed to save
        assertNotEquals(error, "");
        /*if error is "failed to save" then the app tried to save the data in
        the firebase data base which should not be allowed
         */
        expected = "failed to save";
        assertNotEquals(expected, error);
    }

    /**
     * Running a Quiz
     */

    @Rule
    public ActivityTestRule<AnswerQuizActivity> AnswerQuizAct = new ActivityTestRule<>(AnswerQuizActivity.class);

    //a student must do this before starting a quiz
    @Test
    public void addStudentNickname()
    {
        String name = "fred";

        String error = "";
        String expected = "";

        user testUser = new user(name, null);

        UserDatabase userAddDB = new UserDatabase();

        try {
            userAddDB.addUser(name, null);

        }
        catch(Exception e)
        {
            error = "failed to add";
        }

        assertEquals(expected, error);
    }

    @Test
    public void answerQuestionCorrectly()
    {
        //Expected results
        String answerCorrect = "correct";

        String quizId = "EVEKNRGGP35kYsxh1za8";


        TextView rightAnswerTV = AnswerQuizAct.getActivity().RightAnswerTXT;
        //used but not tested here
        TextView questionTV = AnswerQuizAct.getActivity().questionTXT;
        TextView answerATV = AnswerQuizAct.getActivity().answerATXT;
        TextView answerBTV = AnswerQuizAct.getActivity().answerBTXT;
        TextView answerCTV = AnswerQuizAct.getActivity().answerCTXT;
        TextView answerDTV = AnswerQuizAct.getActivity().answerDTXT;


        ProgressBar timePB = AnswerQuizAct.getActivity().TimePB;

        RunQuizController RQC = new RunQuizController(quizId, questionTV, answerATV, answerBTV, answerCTV, answerDTV, timePB, rightAnswerTV);

        RQC.startQuestion();

        RQC.endQuestion("A");

        assertEquals(answerCorrect, rightAnswerTV.getText().toString());

    }

    @Test
    public void answerQuestionInCorrectly()
    {
        //Expected results
        String answerCorrect = "wrong";

        String quizId = "EVEKNRGGP35kYsxh1za8";


        TextView rightAnswerTV = AnswerQuizAct.getActivity().RightAnswerTXT;
        //used but not tested here
        TextView questionTV = AnswerQuizAct.getActivity().questionTXT;
        TextView answerATV = AnswerQuizAct.getActivity().answerATXT;
        TextView answerBTV = AnswerQuizAct.getActivity().answerBTXT;
        TextView answerCTV = AnswerQuizAct.getActivity().answerCTXT;
        TextView answerDTV = AnswerQuizAct.getActivity().answerDTXT;


        ProgressBar timePB = AnswerQuizAct.getActivity().TimePB;

        RunQuizController RQC = new RunQuizController(quizId, questionTV, answerATV, answerBTV, answerCTV, answerDTV, timePB, rightAnswerTV);

        RQC.startQuestion();

        RQC.endQuestion("B");

        assertEquals(answerCorrect, rightAnswerTV.getText().toString());

    }



    @Test
    public void findQuestion()
    {
        /*
        The app will first scan a QR code this works but is not tested as this test
        may not have access to a camera
         */

        //Expected results
        String Question = "Which logic gate only return 1 if both inputs are 1?";
        String AnswerA = "And";
        String AnswerB = "OR";
        String AnswerC = "XOR";
        String AnswerD = "NOT";
        int questionDisplayTime = 60;

        String quizId = "EVEKNRGGP35kYsxh1za8";

        TextView questionTV = AnswerQuizAct.getActivity().questionTXT;
        TextView answerATV = AnswerQuizAct.getActivity().answerATXT;
        TextView answerBTV = AnswerQuizAct.getActivity().answerBTXT;
        TextView answerCTV = AnswerQuizAct.getActivity().answerCTXT;
        TextView answerDTV = AnswerQuizAct.getActivity().answerDTXT;
        //used but not tested here
        TextView rightAnswerTV = AnswerQuizAct.getActivity().RightAnswerTXT;

        ProgressBar timePB = AnswerQuizAct.getActivity().TimePB;

        RunQuizController RQC = new RunQuizController(quizId, questionTV, answerATV, answerBTV, answerCTV, answerDTV, timePB, rightAnswerTV);

        RQC.startQuestion();

        assertEquals(Question, questionTV.getText().toString());

        assertEquals(AnswerA, answerATV.getText().toString());

        assertEquals(AnswerB, answerBTV.getText().toString());

        assertEquals(AnswerC, answerCTV.getText().toString());

        assertEquals(AnswerD, answerDTV.getText().toString());

        //The max value of timePB should be the time that the question should be displayed
        assertEquals(questionDisplayTime, timePB.getMax());


    }







    /*add various other tests about the lecture running the quiz
    and the students getting results
     */
}
