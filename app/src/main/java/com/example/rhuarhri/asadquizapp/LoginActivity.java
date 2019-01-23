package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Databaselayer.UserDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText UserNameET;
    EditText PasswordET;
    Button LoginBTN;
    TextView TitleTXT;

    UserDatabase check = new UserDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserNameET = (EditText) findViewById(R.id.UserNameET);
        PasswordET = (EditText) findViewById(R.id.PasswordET);
        TitleTXT = (TextView) findViewById(R.id.TitleTXT);

        LoginBTN = (Button) findViewById(R.id.LoginBTN);

        LoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = UserNameET.getText().toString();
                String password = PasswordET.getText().toString();
                boolean result = true; //check.checkUser(userName, password);
                if(result == true)
                {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent goToLectureHomeScreen = new Intent(getApplicationContext(), LectureHomeActivity.class);
                    startActivity(goToLectureHomeScreen);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
