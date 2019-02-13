package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.rhuarhri.asadquizapp.Databaselayer.RunQuizDB;

public class quizResultsActivity extends AppCompatActivity {

    Button homeBTN;
    RecyclerView leaderBoardRV;

    RecyclerView.LayoutManager leaderBoardLM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        homeBTN = findViewById(R.id.homeBTN);
        leaderBoardRV = findViewById(R.id.leaderBoardRV);

        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeScreen = new Intent(getApplicationContext(), LectureHomeActivity.class);
                startActivity(goToHomeScreen);
            }
        });

        leaderBoardLM = new LinearLayoutManager(this);

        leaderBoardRV.setLayoutManager(leaderBoardLM);

        RunQuizDB scoreBoard = new RunQuizDB();
        scoreBoard.getLeaderBoard(leaderBoardRV);

    }
}
