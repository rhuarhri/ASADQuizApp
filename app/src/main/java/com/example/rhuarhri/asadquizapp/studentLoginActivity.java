package com.example.rhuarhri.asadquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.UserDatabase;

public class studentLoginActivity extends AppCompatActivity {

    Button bLogin2;
    EditText txtUsernameLogin, txtPasswordLogin;
    TextView errorTXT;
    UserDatabase check;

    String userName = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        bLogin2 = findViewById(R.id.btnLogin2);
        txtUsernameLogin = findViewById(R.id.usernameLogin);
        //txtPasswordLogin = findViewById(R.id.passwordLogin);
        errorTXT = findViewById(R.id.errorTXT);

        check = new UserDatabase(errorTXT, getApplicationContext());

        bLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = txtUsernameLogin.getText().toString();

                check.addUser(userName, password);
            }
        });
    }
}
