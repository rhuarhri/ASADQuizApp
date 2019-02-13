package com.example.rhuarhri.asadquizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.player;
import com.example.rhuarhri.asadquizapp.customDataTypes.quiz;

import java.util.ArrayList;
import java.util.List;

public class leaderBoardRVAdapter extends RecyclerView.Adapter<leaderBoardRVAdapter.ViewHolder> {


    List<String> name;
    List<Integer> score;


    public leaderBoardRVAdapter (List<player> playerList) {
        List<player> allPlayers = playerList;

        name = new ArrayList<String>();
        score = new ArrayList<Integer>();

        for (int i = 0; i < allPlayers.size(); i++) {
            name.add(allPlayers.get(i).getName());
            score.add(allPlayers.get(i).getScore());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_board_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameTXT.setText("" + name.get(position));
        holder.scoreTXT.setText("" + score.get(position));



    }

    @Override
    public int getItemCount() {
        return score.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView nameTXT;
        public TextView scoreTXT;


        public ViewHolder(View v)
        {
            super(v);
            nameTXT = v.findViewById(R.id.nameTXT);
            scoreTXT = v.findViewById(R.id.scoreTXT);

        }
    }



}
