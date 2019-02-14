package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.LectureHomeActivity;
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
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion, final Context context) throws Exception{

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
                            if (context != null)
                            {
                                Intent goToHomeScreen = new Intent(context, LectureHomeActivity.class);
                                context.startActivity(goToHomeScreen);
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //DataAddedSuccessfully = false;
                            isAddingToDataBase = false;

                        }
                    });



        }
        catch (Exception e)
        {
            throw e;
        }



        //return DataAddedSuccessfully;
    }

    @Override
    public void getQuiz(String name, boolean isLecturer, Context context) {

    }

    @Override
    public void getAllQuizzes(List<String> listOfQuizIDs, RecyclerView QuizRV, boolean isLecture, Context context) throws Exception {

    }


    @Override
    public List<question> getAllQuestions(String quizName) throws Exception{

        if(quizName == "")
        {
            throw new Exception("Must have quiz name");
        }





        isAddingToDataBase = true;

        try {

            db.collection("quizzes").whereEqualTo("name", quizName).get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            DocumentSnapshot QuizDocument = queryDocumentSnapshots.getDocuments()
                                    .get(queryDocumentSnapshots.size() - 1);
                            String quizDocumentId = "";
                            quizDocumentId = QuizDocument.getId();

                            db.collection("quizzes").document(quizDocumentId)
                                    .collection("questions").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                                        DocumentSnapshot QuestionDocument = queryDocumentSnapshots.getDocuments().get(i);
                                        question currentQuiz = QuestionDocument.toObject(question.class);
                                        existingQuestions.add(currentQuiz);
                                    }


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                        }})
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });




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

    @Override
    public void getQuestion()
    {
        //Not implemented here
    }

    @Override
    public void checkAnswer(String answer) {
        //Not implemented here
    }

    @Override
    public void getLeaderBoard(RecyclerView LBRV) {
        //Not implemented here
    }

    @Override
    public List<String> getAllStudentsQuizzes(Context context) {
        return null;
    }

    @Override
    public void addQuizForStudent(String quizId, Context context) {

    }

    @Override
    public void removeQuizFromStudent(String quizId, Context context) {

    }
}
