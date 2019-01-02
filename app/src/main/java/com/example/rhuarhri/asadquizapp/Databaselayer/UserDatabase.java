package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class UserDatabase implements userDataBaseInterface {

    FirebaseFirestore db;
    boolean isUser;
    boolean isSearching = true;

    public UserDatabase()
    {
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public boolean checkUser(String name, String password)
    {

        CollectionReference citiesRef = db.collection("user");

        Query query = citiesRef.whereEqualTo("name", "dave").whereEqualTo("password", "123");

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.getResult().isEmpty() == true)
                {
                    isUser = false;
                }
                else
                {
                    isUser = true;
                }
                isSearching = false;
            }
        });


        while (isSearching == true)
        {

        }

        return isUser;
    }
}
