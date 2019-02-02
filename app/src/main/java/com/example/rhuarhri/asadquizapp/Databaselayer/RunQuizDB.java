package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class RunQuizDB implements QuizDataBaseInterface {

    int nextQuestion;

    public RunQuizDB()
    {
        nextQuestion = 0;
    }


    @Override
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion) throws Exception {
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
    public void getQuestion(String QuizID, final TextView questionTXT, final TextView answerATXT, final TextView answerBTXT, final TextView answerCTXT, final TextView answerDTXT) {
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
                                    question currentQuestion = document.toObject(question.class);
                                    if (currentQuestion != null) {
                                        questionTXT.setText(currentQuestion.getQuestion());
                                        answerATXT.setText(currentQuestion.getAnswerA());
                                        answerBTXT.setText(currentQuestion.getAnswerB());
                                        answerCTXT.setText(currentQuestion.getAnswerC());
                                        answerDTXT.setText(currentQuestion.getAnswerD());


                                    }
                                }
                                questionIterator++;
                            }
                        }}
                });
    }

    @Override
    public void checkAnswer(final String answer, String QuizID, final TextView rightAnswerTXT) {
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

                                    question currentQuestion = document.toObject(question.class);

                                    if (currentQuestion != null) {

                                        if(currentQuestion.getRightAnswer().equals(answer) == true)
                                        {
                                            //answer correct
                                            rightAnswerTXT.setText("correct");
                                        }
                                        else
                                        {
                                            //answer wrong
                                            rightAnswerTXT.setText("wrong");
                                        }


                                    }
                                }
                                questionIterator++;
                            }
                        }}
                });
    }

    public void setNextQuestion()
    {
        nextQuestion++;
    }
}
