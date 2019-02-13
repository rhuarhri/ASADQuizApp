package com.example.rhuarhri.asadquizapp.customDataTypes;

public class player {

    private String name;
    //not necessary but improves the reuse of code
    private String password;
    private int score;

    public player()
    {

    }

    public player(String Name, int Score)
    {
        name = Name;
        password = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
