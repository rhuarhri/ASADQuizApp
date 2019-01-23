package com.example.rhuarhri.asadquizapp.customDataTypes;

public class quiz {

    private String Name;
    private String Description;
    private boolean IsLiked;

    public quiz()
    {

    }

    public quiz(String name, String description)
    {
        Name = name;
        Description = description;
        IsLiked = false;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isLiked() {
        return IsLiked;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLiked(boolean liked) {
        IsLiked = liked;
    }
}
