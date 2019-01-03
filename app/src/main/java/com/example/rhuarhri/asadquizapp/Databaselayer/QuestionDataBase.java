package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

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
    public boolean AddQuiz(Map<String, Object> quiz) {
        //not implemented here
        return false;
    }

    @Override
    public boolean AddQuestion(String quizDocumentId, Map<String, Object> question) {

        db.collection("quizzes").document(quizDocumentId)
                .collection("questions").add(question)
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
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {
        //not implemented here
        return null;
    }
}
