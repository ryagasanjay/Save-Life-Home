package com.example.savelifehome;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {
    static final int REQUST_IMAGE_CAPTURE = 1;
    String msg = "Thank you for reporting! Be safe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(takePictureIntent);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUST_IMAGE_CAPTURE);
        }
    }

    public void Imageshot(View view) {
        dispatchTakePictureIntent();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            ImageView imgView = findViewById(R.id.imageView);
            imgView.setImageBitmap(imgBitmap);
        }
    }

    public void home(View view) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Intent toHome = new Intent(this, MainScreen.class);
        startActivity(toHome);
    }
}