package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.CreateQuestionActivity;
import com.example.rhuarhri.asadquizapp.Logiclayer.RunQuizController;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.example.rhuarhri.asadquizapp.questionRVAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizDataBase implements QuizDataBaseInterface{

    FirebaseFirestore db;
    //boolean DataAddedSuccessfully = false;
    boolean isWorkingWithDataBase;
    String QuizDocumentID = "";


    List<quiz> existingQuizzes = new ArrayList<>();

    public QuizDataBase()
    {
        db = FirebaseFirestore.getInstance();
    }



    @Override
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion, final Context context) throws Exception {



        try {
            db.collection("quizzes").add(AddQuiz)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            QuizDocumentID = documentReference.getId();
                            //DataAddedSuccessfully = true;
                            if (context != null)
                            {
                                Intent addQuestionScreen = new Intent(context, CreateQuestionActivity.class);
                                addQuestionScreen.putExtra("ID", QuizDocumentID);
                                context.startActivity(addQuestionScreen);
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //DataAddedSuccessfully = false;

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
    public void getAllQuizzes(List<String> listOfQuizIDs, final RecyclerView QuizRV, boolean isLecture) throws Exception{



        if (isLecture == false)
        {
            //is a student
            for (int i = 0; i < listOfQuizIDs.size(); i++)
            {
                try {

                    db.collection("quizzes").document(listOfQuizIDs.get(i).toString()).get()
                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                    quiz currentQuiz = document.toObject(quiz.class);
                                    if (currentQuiz != null) {
                                        existingQuizzes.add(currentQuiz);
                                    }
                                }

                                RecyclerView.Adapter quizListAdapter = new questionRVAdapter(existingQuizzes);

                                QuizRV.setAdapter(quizListAdapter);
                            }
                        }
                    );



                }
                catch (Exception e)
                {

                }
            }
        }
        else {

            try {

                db.collection("quizzes").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        quiz currentQuiz = document.toObject(quiz.class);
                                        if (currentQuiz != null) {
                                            existingQuizzes.add(currentQuiz);
                                        }
                                    }

                                    RecyclerView.Adapter quizListAdapter = new questionRVAdapter(existingQuizzes);

                                    QuizRV.setAdapter(quizListAdapter);
                                }
                            }
                        });
                /**/


            } catch (Exception e) {

            }
        }




    }

    @Override
    public List<question> getAllQuestions(String quizDocumentID) throws Exception{
        //not implemented here
        return null;
    }


    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {

        /*
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

          */

            return QuizDocumentID;

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

