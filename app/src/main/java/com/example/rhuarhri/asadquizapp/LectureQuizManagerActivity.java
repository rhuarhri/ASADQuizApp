package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Logiclayer.RunQuizController;

public class LectureQuizManagerActivity extends AppCompatActivity {

    String QuizID = "";

    ProgressBar timePB;
    TextView questionTXT;
    TextView AnswerATXT;
    TextView AnswerBTXT;
    TextView AnswerCTXT;
    TextView AnswerDTXT;
    TextView RightAnswerTXT;
    TextView answeredTXT;

    Button homeBTN;
    Button nextBTN;

    RunQuizController runningQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_quiz_manager);

        Intent FromStudentAccess = getIntent();
        Bundle sentData = FromStudentAccess.getExtras();
        if(sentData != null)
        {
            QuizID = (String) sentData.get("id");
        }


        timePB = findViewById(R.id.TimerPB);
        questionTXT = findViewById(R.id.questionTXT);
        answeredTXT = findViewById(R.id.studentsAnsweredTXT);

        homeBTN = findViewById(R.id.HomeBTN);
        nextBTN = findViewById(R.id.NextBTN);

        runningQuiz = new RunQuizController(getApplicationContext(), "", QuizID, questionTXT, AnswerATXT, AnswerBTXT, AnswerCTXT, AnswerDTXT, timePB, RightAnswerTXT);

        runningQuiz.startQuestion();


        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent goToLectureHomeScreen = new Intent(getApplicationContext(), LectureHomeActivity.class);

                startActivity(goToLectureHomeScreen);*/
            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runningQuiz.endQuestion("");

            }
        });

    }
}
