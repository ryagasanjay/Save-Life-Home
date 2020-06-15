package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView signup;
    FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mfirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseUser = mfirebaseAuth.getCurrentUser();
                if (mfirebaseUser != null) {
                    Toast.makeText(Login.this, "You are logged in!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MainScreen.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Login.this, "Please login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        //Go to Sign Up in case you didn't
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailEntered = email.getText().toString();
                String passwordEntered = password.getText().toString();
                if (emailEntered.isEmpty()) {
                    email.setError("Please enter an Email id");
                    email.requestFocus();
                } else if (passwordEntered.isEmpty()) {
                    password.setError("Please enter a Password");
                    password.requestFocus();
                } else if (emailEntered.isEmpty() && passwordEntered.isEmpty()) {
                    Toast.makeText(Login.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(emailEntered.isEmpty() && passwordEntered.isEmpty())) {
                    mfirebaseAuth.signInWithEmailAndPassword(emailEntered, passwordEntered).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                task.getException().printStackTrace();
                                Toast.makeText(Login.this, " Login Error. Please login again!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Login.this, MainScreen.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Login.this, " Error Occured. Please contact the developer!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

    }

    public void onStart() {
        super.onStart();
        mfirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}