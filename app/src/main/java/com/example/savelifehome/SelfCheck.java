package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelfCheck extends AppCompatActivity {
    String passed = "You are fine , But we still advise you to stay at home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_check);
    }


    public void Yes(View view) {
        Intent yes = new Intent(this, Contactinfo.class);
        startActivity(yes);
    }

    public void home(View view) {
        Toast.makeText(getApplicationContext(), passed, Toast.LENGTH_LONG).show();
        Intent toHome = new Intent(this, MainScreen.class);
        startActivity(toHome);

    }
}