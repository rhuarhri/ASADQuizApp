package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;

public class LectureHomeActivity extends AppCompatActivity {

    Button createQuizBTN;
    RecyclerView questionListRV;
    RecyclerView.Adapter questionListAdapter;
    RecyclerView.LayoutManager questionListLM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_home);

        createQuizBTN = (Button) findViewById(R.id.CreateQuizBTN);

        questionListRV = (RecyclerView) findViewById(R.id.questionRV);

        questionListLM = new LinearLayoutManager(this);

        questionListRV.setLayoutManager(questionListLM);

        QuizDataBase QuizBD = new QuizDataBase();

        try {
            QuizBD.getAllQuizzes(questionListRV);
        }
        catch(Exception e)
        {

        }



        //questionListRV.setAdapter(questionListAdapter);

        createQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCreateQuizScreen = new Intent(getApplicationContext(), CreateQuizActivity.class);
                startActivity(goToCreateQuizScreen);
            }
        });

        /*test run of quiz*/
        Button runQuizBTN = (Button) findViewById(R.id.button2);

        runQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoStudentAccess = new Intent(getApplicationContext(), studentAccessActivity.class);
                gotoStudentAccess.putExtra("id", "EVEKNRGGP35kYsxh1za8");
                startActivity(gotoStudentAccess);
            }
        });
    }

}
