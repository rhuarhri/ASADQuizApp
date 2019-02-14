package com.example.rhuarhri.asadquizapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.Logiclayer.QuizManger;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.ArrayList;
import java.util.List;

public class studentRVAdapter extends RecyclerView.Adapter<studentRVAdapter.ViewHolder> {

    //String[] quizNames;
    //Boolean[] isLiked;

    List<String> FoundNames;
    List<String> FoundDescriptions;
    Context context;


    public studentRVAdapter (List<quiz> quizList, Context appContext)
    {
        List<quiz> allQuizzes = quizList;

        FoundNames = new ArrayList<String>();
        FoundDescriptions = new ArrayList<String>();

        context = appContext;

        for (int i = 0; i < allQuizzes.size(); i++)
        {
            FoundNames.add(allQuizzes.get(i).getName());
            FoundDescriptions.add(allQuizzes.get(i).getDescription());
        }

        //quizNames = (String[]) currentlyFoundNames.toArray();
        //isLiked = (Boolean[]) currentlyFoundIsLiked.toArray();

    }



    @NonNull
    @Override
    public studentRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {





        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_quizzes_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final studentRVAdapter.ViewHolder holder, int position) {
        holder.quizNameTXT.setText("" + FoundNames.get(position));
        holder.quizDescriptionTXT.setText("" + FoundDescriptions.get(position));

        holder.runBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizManger quizM = new QuizManger();
                quizM.getQuiz(holder.quizNameTXT.getText().toString(), true, context);
            }
        });
    }



    @Override
    public int getItemCount() {
        return FoundNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView quizNameTXT;
        public TextView quizDescriptionTXT;
        public Button runBTN;

        public ViewHolder(View v)
        {
            super(v);
            quizNameTXT = v.findViewById(R.id.quizNameTXT);
            quizDescriptionTXT = v.findViewById(R.id.quizDescriptionTXT);
            runBTN = v.findViewById(R.id.runBTN);

        }
    }


}
