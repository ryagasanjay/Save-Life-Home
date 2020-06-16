package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Contactinfo extends AppCompatActivity {

    String msg = "Be safe!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactinfo);
    }

    public void home(View view) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Intent toHome = new Intent(this, MainScreen.class);
        startActivity(toHome);
    }
}