package com.example.savelifehome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Mental_health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}