package com.example.savelifehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TestCenter extends AppCompatActivity {
    String s1[], s2[];

    RecyclerView recyclerView;


    //private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_center);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);


        s1 = getResources().getStringArray(R.array.hospitals);
        s2 = getResources().getStringArray(R.array.address);

        TestAdapter tAdapter = new TestAdapter(this, s1, s2);
        recyclerView.setAdapter(tAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void SelfCheck(View view) {
        Intent Scheck = new Intent(this, SelfCheck.class);
        startActivity(Scheck);
    }
}