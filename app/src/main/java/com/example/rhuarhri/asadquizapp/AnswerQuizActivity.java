package com.example.rhuarhri.asadquizapp;

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

        QuizRunning = new RunQuizController("EVEKNRGGP35kYsxh1za8",  questionTXT, answerATXT, answerBTXT, answerCTXT, answerDTXT, TimePB, RightAnswerTXT);


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

    public void getQuestion()
    {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("quizzes").document("EVEKNRGGP35kYsxh1za8")
                .collection("questions").get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult())  {
                        question currentQuestion = document.toObject(question.class);
                        if (currentQuestion != null) {
                            questionTXT.setText(currentQuestion.getQuestion());
                            answerATXT.setText(currentQuestion.getAnswerA());
                            answerBTXT.setText(currentQuestion.getAnswerB());
                            answerCTXT.setText(currentQuestion.getAnswerC());
                            answerDTXT.setText(currentQuestion.getAnswerD());


                        }
                    }
            }}
        });

    }

    }

