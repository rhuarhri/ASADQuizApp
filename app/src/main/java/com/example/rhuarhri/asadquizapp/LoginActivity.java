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
    Button SignInBTN;
    TextView TitleTXT;

    UserDatabase check;

    String userName = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserNameET = (EditText) findViewById(R.id.UserNameET);
        PasswordET = (EditText) findViewById(R.id.PasswordET);
        TitleTXT = (TextView) findViewById(R.id.TitleTXT);

        LoginBTN = (Button) findViewById(R.id.LoginBTN);
        SignInBTN = (Button) findViewById(R.id.signUpBTN);

        check = new UserDatabase(TitleTXT, getApplicationContext());

        SignInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSignUpActivity = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(goToSignUpActivity);
            }
        });

        LoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = UserNameET.getText().toString();
                password = PasswordET.getText().toString();

                check.checkUser(userName, password);
                /*if(TitleTXT.getText() != "logged in")
                {

                }
                else {*/

                //}


/*

                boolean result = true; //check.checkUser(userName, password);
                if(result == true)
                {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

                */
            }
        });

    }

    /*
    private void checkingUserData()
    {

        if (userName == "" || password == "")
        {

        }
        else
        {
            check.checkUser(userName, password, TitleTXT);
        }


    }*/
}
