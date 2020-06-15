package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainScreen extends AppCompatActivity {
    Button reqServices, contactTracing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        reqServices = findViewById(R.id.button17);
        contactTracing = findViewById(R.id.button14);

    }

    public void requestEssentialServices(View view) {
        Intent home = new Intent(this, EssentialServices.class);
        startActivity(home);
    }


    public void startcontactTracing(View view) {
        startActivity(new Intent(this, ContactTracing.class));
    }


    public void showNews(View view) {
        startActivity(new Intent(this, NewsOrAnnouncements.class));
    }

    public void beginVoluntaryServices(View view) {
        startActivity(new Intent(this, NewsOrAnnouncements.class));
    }
}