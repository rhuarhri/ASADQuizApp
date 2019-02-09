package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class StudentHomeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    Button getAccessToQuizBTN;
    Button testBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        getAccessToQuizBTN = (Button) findViewById(R.id.getAccessToQuizBTN);
        testBTN = (Button) findViewById(R.id.testBTN);

        testBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAnswerQuizActivity = new Intent(getApplicationContext(), AnswerQuizActivity.class);
                goToAnswerQuizActivity.putExtra("id", "EVEKNRGGP35kYsxh1za8");
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
        Intent goToAnswerQuizActivity = new Intent(getApplicationContext(), AnswerQuizActivity.class);
        goToAnswerQuizActivity.putExtra("id", result.getText());
        startActivity(goToAnswerQuizActivity);
    }
}
