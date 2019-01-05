package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LectureHomeActivity extends AppCompatActivity {

    Button createQuizBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_home);

        createQuizBTN = (Button) findViewById(R.id.CreateQuizBTN);

        createQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCreateQuizScreen = new Intent(getApplicationContext(), CreateQuizActivity.class);
                startActivity(goToCreateQuizScreen);
            }
        });
    }
}
