package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Volunteer extends AppCompatActivity {
    EditText vname, vphone;
    Button registerVolunteer;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        db = FirebaseFirestore.getInstance();
        vname = findViewById(R.id.editTextPersonName);
        vphone = findViewById(R.id.editTextPhone);
        registerVolunteer = findViewById(R.id.registerVolunteer);

        registerVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = vname.getText().toString();
                String userphone = vphone.getText().toString();


                CollectionReference dbEssentialServices = db.collection("RegisteredVolunteers");
                Model_Volunteers volunteerData = new Model_Volunteers(username, userphone);
                dbEssentialServices.add(volunteerData)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                                db.collection("RegisteredVolunteers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                Log.v("signup ", "Volunteer Services:" + document.getId() + " ==> " + document.getData());
                                            }
                                        } else {
                                            Log.v("signup", "Volunteer Services: Error getting documents since they are not being saved in Firestore at all :/n " + task.getException());
                                        }
                                    }
                                });
                                Toast.makeText(Volunteer.this, "We appreciate you very much for registering as a Volunteer.", Toast.LENGTH_SHORT).show();
                                Intent t = new Intent(Volunteer.this, MainScreen.class);
                                startActivity(t);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.v("signup", "Volunteer Services: Failure Registering a volunteer Request. Error message : " + e.getMessage());
                    }
                });
            }
        });


    }
}