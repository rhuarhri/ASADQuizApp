package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) throws Exception {

        isWorkingWithDataBase = true;

        try {
            db.collection("quizzes").add(AddQuiz)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            QuizDocumentID = documentReference.getId();
                            //DataAddedSuccessfully = true;
                            isWorkingWithDataBase = false;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //DataAddedSuccessfully = false;
                            isWorkingWithDataBase = false;
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
    public void getAllQuizzes(final RecyclerView QuizRV) throws Exception{



        try {

            db.collection("quizzes").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult())  {
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


        }
        catch (Exception e)
        {

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
    public void getQuestion(String QuizID, final TextView questionTXT, final TextView answerATXT, final TextView answerBTXT, final TextView answerCTXT, final TextView answerDTXT, final ProgressBar TimerPB)
    {
        //Not implemented here
    }

    @Override
    public void checkAnswer(String answer, String QuizID, TextView rightAnswerTXT) {
        //Not implemented here
    }


}

