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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionDataBase implements QuizDataBaseInterface{

    FirebaseFirestore db;
    //boolean DataAddedSuccessfully = false;
    boolean isAddingToDataBase = true;

    List<question> existingQuestions = new ArrayList<>();

    public QuestionDataBase()
    {
        db = FirebaseFirestore.getInstance();
    }


    @Override
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) throws Exception{

        if(quizDocumentId == "")
        {
            throw new Exception("must run get document id of the quiz first");
        }

        isAddingToDataBase = true;

        try {

            db.collection("quizzes").document(quizDocumentId)
                    .collection("questions").add(AddQuestion)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            //DataAddedSuccessfully = true;
                            isAddingToDataBase = false;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //DataAddedSuccessfully = false;
                            isAddingToDataBase = false;

                        }
                    });

            while (isAddingToDataBase == true)
            {

            }

        }
        catch (Exception e)
        {
            throw e;
        }



        //return DataAddedSuccessfully;
    }

    @Override
    public List<quiz> getAllQuizzes() {
        //not implemented here

        return null;
    }

    @Override
    public List<question> getAllQuestions(String quizDocumentId) throws Exception{

        if(quizDocumentId == "")
        {
            throw new Exception("must run get document id of the quiz first");
        }



        isAddingToDataBase = true;

        try {

            db.collection("quizzes").document(quizDocumentId)
                    .collection("questions").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        DocumentSnapshot QuestionDocument = queryDocumentSnapshots.getDocuments().get(i);
                        question currentQuiz = QuestionDocument.toObject(question.class);
                        existingQuestions.add(currentQuiz);
                    }

                    isAddingToDataBase = false;
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    isAddingToDataBase = false;
                }
            });

            while (isAddingToDataBase == true)
            {

            }

        }
        catch (Exception e)
        {
            throw e;
        }







        return existingQuestions;
    }


    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {
        //not implemented here
        return null;
    }
}
