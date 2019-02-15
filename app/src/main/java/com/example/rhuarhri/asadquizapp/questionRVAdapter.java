package com.example.rhuarhri.asadquizapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;
import com.example.rhuarhri.asadquizapp.Logiclayer.QuizManger;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.ArrayList;
import java.util.List;

public class questionRVAdapter extends RecyclerView.Adapter<questionRVAdapter.ViewHolder> {

    //String[] quizNames;
    //Boolean[] isLiked;

    List<String> FoundNames;
    List<Boolean> FoundIsLiked;
    Context context;


    public questionRVAdapter (List<quiz> quizList, Context appContext)
    {
        List<quiz> allQuizzes = quizList;

        FoundNames = new ArrayList<String>();
        FoundIsLiked = new ArrayList<Boolean>();

        context = appContext;

        for (int i = 0; i < allQuizzes.size(); i++)
        {
            FoundNames.add(allQuizzes.get(i).getName());
            FoundIsLiked.add(allQuizzes.get(i).isLiked());
        }

        //quizNames = (String[]) currentlyFoundNames.toArray();
        //isLiked = (Boolean[]) currentlyFoundIsLiked.toArray();

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //QuizDataBase getAllQuizzes = new QuizDataBase();


/*
        try {
            allQuizzes = getAllQuizzes.getAllQuizzes();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }*/



        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.quizNameTXT.setText("" + FoundNames.get(position));
        if(FoundIsLiked.get(position) == true)
        {
            holder.likeBTN.setBackgroundResource(R.drawable.heart);
        }
        else
        {
            holder.likeBTN.setBackgroundResource(R.drawable.heart_hollow);
        }

        holder.runBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizManger quizM = new QuizManger();
                quizM.getQuiz(FoundNames.get(position), true, context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return FoundIsLiked.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView quizNameTXT;
        public Button likeBTN;
        public Button runBTN;

        public ViewHolder(View v)
        {
            super(v);
            quizNameTXT = v.findViewById(R.id.quizzNameTXT);
            likeBTN = v.findViewById(R.id.likeBTN);
            runBTN = v.findViewById(R.id.RunBTN);

        }
    }


}
