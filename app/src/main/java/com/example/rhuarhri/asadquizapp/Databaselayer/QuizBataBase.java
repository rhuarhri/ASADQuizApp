package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class QuizBataBase implements QuizDataBaseInterface{

    FirebaseFirestore db;
    boolean DataAddedSuccessfully = false;
    boolean isWorkingWithDataBase;
    String QuizDocumentID = "";

    public QuizBataBase()
    {
        db = FirebaseFirestore.getInstance();
    }


    @Override
    public boolean AddQuiz(Map<String, Object> quiz) {

        isWorkingWithDataBase = true;

        db.collection("quizzes").add(quiz)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        QuizDocumentID = documentReference.getId();
                        DataAddedSuccessfully = true;
                        isWorkingWithDataBase = false;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        DataAddedSuccessfully = false;
                        isWorkingWithDataBase = false;
                    }
                });

        while(isWorkingWithDataBase == true)
        {

        }

        return DataAddedSuccessfully;
    }

    @Override
    public boolean AddQuestion(String quizDocumentId, Map<String, Object> question) {
        //not implemented here
        return false;
    }

    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {

        if(newToDataBase == true)
        {
            return QuizDocumentID;
        }
        else {
            isWorkingWithDataBase = true;
            db.collection("quizzes").whereEqualTo("name", QuizName).get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            DocumentSnapshot QuizDocument = queryDocumentSnapshots.getDocuments()
                                    .get(queryDocumentSnapshots.size() - 1);
                            QuizDocumentID = QuizDocument.getId();
                            isWorkingWithDataBase = false;
                        }})
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            QuizDocumentID = "";
                        }
            });

            while (isWorkingWithDataBase == true)
            {

            }

            return QuizDocumentID;

        }



    }
}
