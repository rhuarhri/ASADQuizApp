package com.example.rhuarhri.asadquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                boolean result = check.checkUser(userName, password);
                if(result == true)
                {
                    TitleTXT.setText("success");
                }
                else
                {
                    TitleTXT.setText("failed");
                }
            }
        });

    }
}
