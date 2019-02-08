package com.example.rhuarhri.asadquizapp.Databaselayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.rhuarhri.asadquizapp.LectureHomeActivity;
import com.example.rhuarhri.asadquizapp.StudentHomeActivity;
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

    TextView errorTXT;
    Context context;

    public UserDatabase(TextView errorTextView, Context activityContext)
    {
        errorTXT = errorTextView;
        context = activityContext;
    }

    @Override
    public void checkUser(String name, String password)
    {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        CollectionReference colRef = db.collection("user");

        Query query = colRef.whereEqualTo("name", name ).whereEqualTo("password", password);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.getResult().isEmpty() == true)
                {
                    //Not a user
                    errorTXT.setText("login failed");
                }
                else
                {
                    //Is a user
                    errorTXT.setText("login successful");
                    if (context != null)
                    {
                        Intent goToLectureHomeScreen = new Intent(context, LectureHomeActivity.class);
                        context.startActivity(goToLectureHomeScreen);
                    }
                }

            }
        });



    }

    @Override
    public void addUser(String name, String password) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        user addUser = new user(name, password);

        CollectionReference colRef;

        if (password == "" || password == null) {
            //adding student
            //this ensures that no problems occur from inserting a null value
            addUser = new user(name, "");
            colRef = db.collection("leaderboard");

        }
        else{

            //adding a lecture
            colRef = db.collection("user");

        }


            checkIfNameExists(colRef, addUser);


    }

    private void checkIfNameExists(final CollectionReference colRef, final user addUser)
    {
        colRef.whereEqualTo("name", addUser.getUserName() )
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if(task.getResult().isEmpty() == true)
            {
                //Name unique
                try {
                    addData(colRef, addUser);
                }
                catch(Exception e)
                {

                    errorTXT.setText("failed to save");

                }
            }
            else
            {
                //Name already exists
                if (errorTXT != null)
                {
                    errorTXT.setText("Name already exists");
                }


            }

        }
    });
    }

    private void addData(CollectionReference colRef, final user addUser) throws Exception
    {
        try {
            colRef.add(addUser)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            //user added successfully
                            errorTXT.setText("successful");
                            if (addUser.getPassword() == "")
                            {
                                //student added
                                Intent goToStudentHomeScreen = new Intent(context, StudentHomeActivity.class);
                                context.startActivity(goToStudentHomeScreen);
                            }
                            else
                            {
                                //lecture added
                                Intent goToLectureHomeScreen = new Intent(context, LectureHomeActivity.class);
                                context.startActivity(goToLectureHomeScreen);
                            }
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
