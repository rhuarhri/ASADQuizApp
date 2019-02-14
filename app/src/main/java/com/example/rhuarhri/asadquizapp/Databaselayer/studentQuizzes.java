package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.rhuarhri.asadquizapp.customDataTypes.question;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.ArrayList;
import java.util.List;

public class studentQuizzes implements QuizDataBaseInterface {
    @Override
    public void Add(String quizDocumentId, quiz AddQuiz, question AddQuestion, Context context) throws Exception {

    }

    @Override
    public void getQuiz(String name, boolean isLecturer, Context context) {

    }

    @Override
    public void getAllQuizzes(List<String> listOfQuizIDs, RecyclerView QuizRV, boolean isLecture, Context context) throws Exception {

    }


    @Override
    public List<question> getAllQuestions(String quizDocumentId) throws Exception {
        return null;
    }

    @Override
    public String getQuizDocumentID(boolean newToDataBase, String QuizName) {
        return null;
    }

    @Override
    public void getQuestion() {

    }

    @Override
    public void checkAnswer(String answer) {

    }

    @Override
    public void getLeaderBoard(RecyclerView LBRV) {

    }

    @Override
    public List<String> getAllStudentsQuizzes(Context context) {

        List<String> allQuizID = new ArrayList<>();

        quizAccessDB accessableQuizzes = Room.databaseBuilder(context, quizAccessDB.class, "quizIdDB").allowMainThreadQueries().build();

        List<storedQuizId> data = accessableQuizzes.storedQuizzes().getAll();

        for (int i = 0; i < data.size(); i++)
        {
            allQuizID.add(data.get(i).quizId);
        }

        return allQuizID;
    }

    @Override
    public void addQuizForStudent(String quizId, Context context) {

        storedQuizId newQuiz = new storedQuizId();

        newQuiz.setQuizId(quizId);

        quizAccessDB accessableQuizzes = Room.databaseBuilder(context, quizAccessDB.class, "quizIdDB").allowMainThreadQueries().build();

        accessableQuizzes.storedQuizzes().add(newQuiz);

    }

    @Override
    public void removeQuizFromStudent(String quizId, Context context) {

        storedQuizId oldQuiz = new storedQuizId();

        oldQuiz.setQuizId(quizId);

        quizAccessDB accessableQuizzes = Room.databaseBuilder(context, quizAccessDB.class, "quizIdDB").allowMainThreadQueries().build();

        accessableQuizzes.storedQuizzes().delete(oldQuiz);

    }


}
