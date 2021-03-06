package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Databaselayer.studentQuizzes;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuizManger;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class StudentHomeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    Button getAccessToQuizBTN;
    Button testBTN;
    RecyclerView studentRV;
    RecyclerView.LayoutManager studentLM;

    String studentName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Intent fromStudentLogin = getIntent();
        Bundle sentData = fromStudentLogin.getExtras();
        if (sentData != null) {

            studentName = (String) sentData.get("name");
        }

        Toast.makeText(this, "Welcome " + studentName, Toast.LENGTH_SHORT).show();

        getAccessToQuizBTN = (Button) findViewById(R.id.getAccessToQuizBTN);
        testBTN = (Button) findViewById(R.id.testBTN);
        studentRV = (RecyclerView) findViewById(R.id.studentQuizzesRV);

        studentLM = new LinearLayoutManager(this);

        studentRV.setLayoutManager(studentLM);

        QuizManger quizM = new QuizManger();

        quizM.DisplayExistingQuizzes(studentRV, false, getApplicationContext());


        testBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentQuizzes newQuiz = new studentQuizzes();

                newQuiz.addQuizForStudent("EVEKNRGGP35kYsxh1za8", getApplicationContext());

                Intent goToAnswerQuizActivity = new Intent(getApplicationContext(), AnswerQuizActivity.class);
                goToAnswerQuizActivity.putExtra("id", "EVEKNRGGP35kYsxh1za8");
                goToAnswerQuizActivity.putExtra("name", studentName);
                startActivity(goToAnswerQuizActivity);
            }
        });

        getAccessToQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QRScanner();
            }
        });
    }

    public void QRScanner(){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {

        studentQuizzes newQuiz = new studentQuizzes();

        newQuiz.addQuizForStudent(result.getText().toString(), getApplicationContext());


        Intent goToAnswerQuizActivity = new Intent(getApplicationContext(), AnswerQuizActivity.class);
        goToAnswerQuizActivity.putExtra("id", result.getText());
        goToAnswerQuizActivity.putExtra("name", studentName);
        startActivity(goToAnswerQuizActivity);
    }
}
