package com.example.rhuarhri.asadquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateQuizActivity extends AppCompatActivity {

    FirebaseFirestore db;
    EditText nameET;
    Button addBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        db = FirebaseFirestore.getInstance();

        nameET = (EditText) findViewById(R.id.QuizNameTXT);

        addBTN = (Button) findViewById(R.id.AddBTN);

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = nameET.getText().toString();

                Map<String, Object> quiz = new HashMap<>();
                quiz.put("name", data);

                db.collection("quizzes").add(quiz)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                            }
                        });

            }
        });


    }
}
