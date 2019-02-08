package com.example.rhuarhri.asadquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.UserDatabase;

public class SignUpActivity extends AppCompatActivity {

    TextView errorTXT;
    Button saveBTN;
    EditText passwordET;
    EditText nameET;
    UserDatabase addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        errorTXT = (TextView) findViewById(R.id.errorTXT);
        saveBTN = (Button) findViewById(R.id.signupBTN);
        passwordET = (EditText) findViewById(R.id.passwordET);
        nameET = (EditText) findViewById(R.id.nameET);

        addUser = new UserDatabase(errorTXT, getApplicationContext());

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String password = passwordET.getText().toString();
                addUser.addUser(name, password);
            }
        });
    }
}
