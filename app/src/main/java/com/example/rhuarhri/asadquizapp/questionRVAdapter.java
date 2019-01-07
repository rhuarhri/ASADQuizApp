package com.example.rhuarhri.asadquizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class questionRVAdapter extends RecyclerView.Adapter<questionRVAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.quizNameTXT.setText("Test");

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
