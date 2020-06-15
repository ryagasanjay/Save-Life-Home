package com.example.savelifehome;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class EssentialServices extends AppCompatActivity {

    EditText name, phone, instructions;
    RadioGroup category;
    Button register;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essential_services);
        db = FirebaseFirestore.getInstance();
        name = findViewById(R.id.req_Name);
        phone = findViewById(R.id.req_phone);
        instructions = findViewById(R.id.req_instructions);
        category = (RadioGroup) findViewById(R.id.req_category);
        register = findViewById(R.id.request_service);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String userphone = phone.getText().toString();
                String userCategory = "";
                String userInstructions = instructions.getText().toString();
                int selectedRadioButtonID = category.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonID);
                    userCategory = selectedRadioButton.getText().toString();

                } else {
                    Toast.makeText(EssentialServices.this, "Please select a category.", Toast.LENGTH_SHORT).show();
                }

                CollectionReference dbEssentialServices = db.collection("EssentialServices");
                Model_EssentialService essentialServiceData = new Model_EssentialService(username, userphone, userInstructions, userCategory);
                dbEssentialServices.add(essentialServiceData)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                                db.collection("EssentialServices").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                Log.v("signup", document.getId() + " ==> " + document.getData());
                                            }
                                        } else {
                                            Log.v("signup", "Error getting documents since they are not being saved in Firestore at all :/n " + task.getException());
                                        }
                                    }
                                });
                                Toast.makeText(EssentialServices.this, "We got your request and help is on the way.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.v("signup", "Essential Services: Failure Registering a request. Error message : " + e.getMessage());
                    }
                });
            }
        });
    }


}