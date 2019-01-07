package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;

public class QuestionDataBase implements QuizDataBaseInterface{

    FirebaseFirestore db;
    boolean DataAddedSuccessfully = false;
    boolean isAddingToDataBase = true;

    public QuestionDataBase()
    {
        db = FirebaseFirestore.getInstance();
    }


    @Override
    public boolean Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) {
        db.collection("quizzes").document(quizDocumentId)
                .collection("questions").add(AddQuestion)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        DataAddedSuccessfully = true;
                        isAddingToDataBase = false;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        DataAddedSuccessfully = false;
                        isAddingToDataBase = false;
                    }
                });

        while (isAddingToDataBase == true)
        {

        }

        return DataAddedSuccessfully;
    }

    @Override
    public List<quiz> getAllQuizzes() {
        //not implemented here

        return null;
    }

    @Override
    public List<question> getAllQuestions() {
        return null;
    }


    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {
        //not implemented here
        return null;
    }
}
