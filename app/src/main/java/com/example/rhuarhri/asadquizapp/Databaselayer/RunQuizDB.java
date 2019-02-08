package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Logiclayer.RunQuizController;
import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class RunQuizDB implements QuizDataBaseInterface {

    int nextQuestion;
    RunQuizController RQC;
    String QuestionDocumentID = "";

    public RunQuizDB()
    {
        nextQuestion = 0;
    }


    @Override
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion, Context context) throws Exception {
        //Not implemented here
    }

    @Override
    public void getAllQuizzes(RecyclerView QuizRV) throws Exception {
        //Not implemented here
    }

    @Override
    public List<question> getAllQuestions(String quizDocumentId) throws Exception {
        //Not implemented here
        return null;
    }

    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {
        //Not implemented here
        return null;
    }

    @Override
    public void getQuestion(String QuizID, final TextView questionTXT, final TextView answerATXT, final TextView answerBTXT, final TextView answerCTXT, final TextView answerDTXT, final ProgressBar TimerPB) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();



        db.collection("quizzes").document(QuizID)
                .collection("questions").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int questionIterator = 0;
                            for (QueryDocumentSnapshot document : task.getResult())  {
                                if (questionIterator == nextQuestion) {
                                    QuestionDocumentID = document.getId().toString();
                                    question currentQuestion = document.toObject(question.class);
                                    if (currentQuestion != null) {
                                        /*
                                        This is necessary as this function is used in multiple places
                                        so the following variables need to be checked
                                         */
                                        if (questionTXT != null){
                                        questionTXT.setText(currentQuestion.getQuestion());}
                                        if(answerATXT != null){
                                        answerATXT.setText("A: " + currentQuestion.getAnswerA());}
                                        if(answerBTXT != null){
                                        answerBTXT.setText("B: " + currentQuestion.getAnswerB());}
                                        if(answerCTXT != null){
                                        answerCTXT.setText("C: " + currentQuestion.getAnswerC());}
                                        if(answerDTXT != null){
                                        answerDTXT.setText("D: " + currentQuestion.getAnswerD());}

                                        if(TimerPB != null) {
                                            RQC = new RunQuizController();
                                            RQC.startQuestionTimer(currentQuestion.getTime(), TimerPB);
                                        }

                                    }
                                }
                                questionIterator++;
                            }
                        }}
                });
/*
        db.collection("quizzes").document(QuizID).collection("questions").document(QuestionDocumentID)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    //Log.d(TAG, "Current data: " + snapshot.getData());
                    //TODO find a way that the lecture can end the question from their app

                } else {
                    //Log.d(TAG, "Current data: null");
                }
            }
        });
        */
    }

    @Override
    public void checkAnswer(final String answer, String QuizID, final TextView rightAnswerTXT) {

        if(answer == "")
        {
            //answer wrong
            rightAnswerTXT.setText("wrong");
        }
        else {

            RQC.stopQuestionTimer();

            FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("quizzes").document(QuizID)
                    .collection("questions").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                int questionIterator = 0;
                                for (QueryDocumentSnapshot document : task.getResult()) {


                                    if (questionIterator == nextQuestion) {

                                        question currentQuestion = document.toObject(question.class);

                                        if (currentQuestion != null) {

                                            if (currentQuestion.getRightAnswer().equals(answer) == true) {
                                                //answer correct
                                                rightAnswerTXT.setText("correct");
                                            } else {
                                                //answer wrong
                                                rightAnswerTXT.setText("wrong");
                                            }


                                        }
                                    }
                                    questionIterator++;
                                }
                            }
                        }
                    });
        }
    }

    public void setNextQuestion()
    {
        nextQuestion++;
    }
}
