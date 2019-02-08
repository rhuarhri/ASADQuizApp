package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Intent;
import android.widget.TextView;

public interface userDataBaseInterface {

    public void checkUser(String name, String password, TextView loggedInDisplay);

    void addUser(String name, String password) throws Exception;
}
