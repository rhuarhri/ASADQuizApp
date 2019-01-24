package com.example.rhuarhri.asadquizapp.customDataTypes;

public class user {

    private String UserName;
    private String Password;

    public user()
    {

    }

    public user(String username, String password)
    {
        UserName = username;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
