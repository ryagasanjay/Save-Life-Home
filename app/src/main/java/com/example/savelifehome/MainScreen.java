package com.example.savelifehome;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainScreen extends AppCompatActivity {
    Button reqServices, contactTracing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_controller_view_tag);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_frag);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        reqServices = findViewById(R.id.requestServices);
//        contactTracing = findViewById(R.id.ContactTracing);

    }

//    public void requestEssentialServices(View view) {
//        Intent home = new Intent(this, EssentialServices.class);
//        startActivity(home);
//    }
//
//
//    public void startcontactTracing(View view) {
//        startActivity(new Intent(this, ContactTracing.class));
//    }
//
//
//    public void showNews(View view) {
//        startActivity(new Intent(this, NewsOrAnnouncements.class));
//    }
//
//    public void beginVoluntaryServices(View view) {
//        startActivity(new Intent(this, Volunteer.class));
//    }
}