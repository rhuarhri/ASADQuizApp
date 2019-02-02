package com.example.rhuarhri.asadquizapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rhuarhri.asadquizapp.Logiclayer.QuestionManger;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuizManger;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class CreateQuizActivity extends AppCompatActivity {

    //FirebaseFirestore db;
    EditText nameET;
    EditText descriptionET;
    Button saveBTN;
    Button addQuestionBTN;
    QuizManger quizManger = new QuizManger();
    String QuizID = "";

    quiz newQuiz = new quiz();

    //Map<String, Object> quiz = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        //db = FirebaseFirestore.getInstance();

        nameET = (EditText) findViewById(R.id.QuizNameET);

        descriptionET = (EditText) findViewById(R.id.QuizDescriptionET);

        saveBTN = (Button) findViewById(R.id.SaveBTN);


        //quiz.put("name", "test2");

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNewQuiz();



            }
        });

        addQuestionBTN = (Button) findViewById(R.id.AddQuestionBTN);

        addQuestionBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNewQuiz();

                Intent addQuestionScreen = new Intent(getApplicationContext(), CreateQuestionActivity.class);
                addQuestionScreen.putExtra("ID", QuizID);
                startActivity(addQuestionScreen);

            }
        });



    }

    private void saveNewQuiz()
    {
        String quizName = nameET.getText().toString();
        String quizDescription = descriptionET.getText().toString();

        newQuiz.setName(quizName);

        newQuiz.setDescription(quizDescription);

        String error = quizManger.add(newQuiz, null);

        if(error != "") {
            Toast.makeText(CreateQuizActivity.this, "ERROR: " + error, Toast.LENGTH_LONG).show();
        }
        else
        {
            QuizID = quizManger.getQuizDocumentID();
        }
    }
}


/*
                db.collection("quizzes").add(quiz)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                            }
                        });

                db.collection("quizzes").whereEqualTo("name", "test2").get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                DocumentSnapshot lastVisible = queryDocumentSnapshots.getDocuments()
                                        .get(queryDocumentSnapshots.size() -1);

                                db.collection("quizzes").document(lastVisible.getId())
                                        .collection("questions").add(quiz)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {

                                            }
                                        });
                            }
                        });
                        */
