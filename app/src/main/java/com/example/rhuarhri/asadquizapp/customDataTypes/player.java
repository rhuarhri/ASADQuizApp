package com.example.rhuarhri.asadquizapp.customDataTypes;

public class player {

    private String name;
    private int score;

    public player()
    {

    }

    public player(String Name, int Score)
    {
        name = Name;
        score = Score;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
