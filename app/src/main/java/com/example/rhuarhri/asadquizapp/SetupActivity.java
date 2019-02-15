package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetupActivity extends AppCompatActivity {

    Button lectureBTN;
    Button studentBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        lectureBTN = (Button) findViewById(R.id.lectureBTN);
        studentBTN = (Button) findViewById(R.id.studentBTN);

        lectureBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLoginScreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(goToLoginScreen);
            }
        });

        studentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStudentLogin = new Intent(getApplicationContext(), studentLoginActivity.class);
                startActivity(goToStudentLogin);
            }
        });
    }
}
