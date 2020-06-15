package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


public class Signup extends AppCompatActivity {
    public EditText registeremail, registerpassword;
    Button btnregister;
    TextView btnlogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        registeremail = findViewById(R.id.email);
        btnregister = findViewById(R.id.signUp);
        btnlogin = findViewById(R.id.btnlogin);
        registerpassword = findViewById(R.id.registerPassword);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = registeremail.getText().toString();
                String pwd = registerpassword.getText().toString();
                if (email.isEmpty()) {
                    registeremail.setError("Please enter an Email ID.");
                    registeremail.requestFocus();
                } else if (email.isEmpty()) {
                    registerpassword.setError("Please enter an Email ID.");
                    registerpassword.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Signup.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.v("signup", "createUserWithEmail:onComplete:" + task.isSuccessful());

                            if (!task.isSuccessful()) {
                                String s = "Sign up Failed" + task.getException();
                                Log.v("signup", s);
                                Toast.makeText(Signup.this, "Sign Up is unsuccessful, Please try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                FirebaseUser user = mAuth.getCurrentUser(); //You Firebase user
                                // user registered, start profile activity
                                Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(Signup.this, MainScreen.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Signup.this, "Error Occured. Please contact the developer.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //go to login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, Login.class);
                startActivity(i);
            }
        });
    }

}
