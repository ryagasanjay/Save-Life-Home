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

public class ContactTracing extends AppCompatActivity {

    EditText cname, cphone, caddress;
    Button registerContact;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_tracing);

        db = FirebaseFirestore.getInstance();
        cname = findViewById(R.id.contact_name);
        cphone = findViewById(R.id.contact_phone);
        caddress = findViewById(R.id.contact_addresses);
        registerContact = findViewById(R.id.addContact);

        registerContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = cname.getText().toString();
                String userphone = cphone.getText().toString();
                String contactAddresses = caddress.getText().toString();


                CollectionReference dbEssentialServices = db.collection("RegisterContactsToTrace");
                Model_ContactsForTracing contactData = new Model_ContactsForTracing(username, userphone, contactAddresses);
                dbEssentialServices.add(contactData)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                                db.collection("RegisterContactsToTrace").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                Log.v("signup ", "ContactTracing Services:" + document.getId() + " ==> " + document.getData());
                                            }
                                        } else {
                                            Log.v("signup", "ContactTracing Services: Error getting documents since they are not being saved in Firestore at all :/n " + task.getException());
                                        }
                                    }
                                });
                                Toast.makeText(ContactTracing.this, "We appreciate you very much for sharing this data for our reference.", Toast.LENGTH_SHORT).show();
                                Intent t = new Intent(ContactTracing.this, MainScreen.class);
                                startActivity(t);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.v("signup", "ContactTracing Services: Failure Registering a volunteer Request. Error message : " + e.getMessage());
                    }
                });
            }
        });
    }
}