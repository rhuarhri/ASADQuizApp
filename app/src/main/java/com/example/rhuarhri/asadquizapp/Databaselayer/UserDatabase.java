package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.customDataTypes.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
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

    @Override
    public void addUser(String name, String password) throws Exception {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        user addUser = new user(name, password);

        if (password == "" || password == null) {
            //adding student
            //this ensures that no problems occur from inserting a null value
            addUser = new user(name, "");
            try {
                db.collection("leaderboard").add(addUser)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //student added successfully
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });


            } catch (Exception e) {
                throw e;
            }
        }
        else{

            //adding a lecture

            try {
                db.collection("user").add(addUser)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //lecture added successfully
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });


            } catch (Exception e) {
                throw e;
            }
        }
    }


}
