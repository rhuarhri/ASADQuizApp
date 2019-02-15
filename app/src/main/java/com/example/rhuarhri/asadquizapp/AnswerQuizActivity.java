package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.RunQuizDB;
import com.example.rhuarhri.asadquizapp.Logiclayer.RunQuizController;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AnswerQuizActivity extends AppCompatActivity {

    String studentName = "ted";
    String quizId = "";

    ProgressBar TimePB;

    TextView questionTXT;
    TextView answerATXT;
    TextView answerBTXT;
    TextView answerCTXT;
    TextView answerDTXT;

    TextView RightAnswerTXT;

    Button ABTN;
    Button BBTN;
    Button CBTN;
    Button DBTN;

    RunQuizController QuizRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_quiz);

        Intent fromQRScanner = getIntent();
        Bundle sentData = fromQRScanner.getExtras();
        if (sentData != null) {
            quizId = (String) sentData.get("id");
            studentName = (String) sentData.get("name");
        }

        TimePB = findViewById(R.id.timerPB);

        questionTXT = findViewById(R.id.questionTXT);
        answerATXT = findViewById(R.id.answerATXT);
        answerBTXT = findViewById(R.id.answerBTXT);
        answerCTXT = findViewById(R.id.answerCTXT);
        answerDTXT = findViewById(R.id.answerDTXT);

        RightAnswerTXT = findViewById(R.id.rightAnswerTXT);

        ABTN = findViewById(R.id.ABTN);
        BBTN = findViewById(R.id.BBTN);
        CBTN = findViewById(R.id.CBTN);
        DBTN = findViewById(R.id.DBTN);

        QuizRunning = new RunQuizController(getApplicationContext(), studentName, quizId, questionTXT, answerATXT, answerBTXT, answerCTXT, answerDTXT, TimePB, RightAnswerTXT);


        QuizRunning.startQuestion();

        ABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizRunning.endQuestion("A");

            }
        });

        BBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizRunning.endQuestion("B");
            }
        });

        CBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizRunning.endQuestion("C");
            }
        });

        DBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizRunning.endQuestion("D");


            }
        });


    }
}


