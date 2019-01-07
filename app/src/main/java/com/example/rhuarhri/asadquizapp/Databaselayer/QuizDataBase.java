package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class QuizDataBase implements QuizDataBaseInterface{

    FirebaseFirestore db;
    boolean DataAddedSuccessfully = false;
    boolean isWorkingWithDataBase;
    String QuizDocumentID = "";

    List<quiz> existingQuizzes;

    public QuizDataBase()
    {
        db = FirebaseFirestore.getInstance();
    }



    @Override
    public boolean Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) {

        isWorkingWithDataBase = true;

        db.collection("quizzes").add(AddQuiz)
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
    public List<quiz> getAllQuizzes() {

        db.collection("quizzes").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (int i = 0; i < queryDocumentSnapshots.size(); i++)
                        {
                            DocumentSnapshot QuizDocument = queryDocumentSnapshots.getDocuments().get(i);
                            quiz currentQuiz = QuizDocument.toObject(quiz.class);
                            existingQuizzes.add(currentQuiz);
                        }
                    }
                });

        return existingQuizzes;
    }

    @Override
    public List<question> getAllQuestions() {
        //not implemented here
        return null;
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
