package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;


public class UserDatabase implements userDataBaseInterface {

    /*
    boolean isUser;
    boolean isSearching = true;*/

    public UserDatabase()
    {

    }

    @Override
    public void checkUser(String name, String password, final TextView loggedInDisplay)
    {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        CollectionReference citiesRef = db.collection("user");

        Query query = citiesRef.whereEqualTo("name", name ).whereEqualTo("password", password);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.getResult().isEmpty() == true)
                {
                    //Not a user
                    loggedInDisplay.setText("not logged in");
                }
                else
                {
                    //Is a user
                    loggedInDisplay.setText("logged in");
                }

            }
        });



    }


}
