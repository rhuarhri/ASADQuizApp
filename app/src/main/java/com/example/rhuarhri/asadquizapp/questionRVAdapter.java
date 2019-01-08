package com.example.rhuarhri.asadquizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Databaselayer.QuizDataBase;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.ArrayList;
import java.util.List;

public class questionRVAdapter extends RecyclerView.Adapter<questionRVAdapter.ViewHolder> {

    String[] quizNames;
    Boolean[] isLiked;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        QuizDataBase getAllQuizzes = new QuizDataBase();

        List<quiz> allQuizzes = new ArrayList<>();

        try {
            allQuizzes = getAllQuizzes.getAllQuizzes();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }


        List<String> currentlyFoundNames = new ArrayList<String>();
        List<Boolean> currentlyFoundIsLiked = new ArrayList<Boolean>();

        for (int i = 0; i < allQuizzes.size(); i++)
        {
            currentlyFoundNames.add(allQuizzes.get(i).getName());
            currentlyFoundIsLiked.add(allQuizzes.get(i).isLiked());
        }

        quizNames = (String[]) currentlyFoundNames.toArray();
        isLiked = (Boolean[]) currentlyFoundIsLiked.toArray();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.quizNameTXT.setText("" + quizNames[position]);
        if(isLiked[position] == true)
        {
            holder.likeBTN.setBackgroundResource(R.drawable.heart);
        }
        else
        {
            holder.likeBTN.setBackgroundResource(R.drawable.heart_hollow);
        }

    }

    @Override
    public int getItemCount() {
        return 0;
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
