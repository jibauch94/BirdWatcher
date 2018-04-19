package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class CreateObsActivity extends AppCompatActivity {

    private EditText danishName, englishName, longitude, latitude, date;
    private Button submit;
    private HashMap<String, String> hashmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_obs);

        danishName = findViewById(R.id.danishName);
        englishName = findViewById(R.id.englishName);
        longitude = findViewById(R.id.longitude);
        latitude = findViewById(R.id.latitude);
        date = findViewById(R.id.date);
        submit = findViewById(R.id.submitBtn);

        Intent intent = getIntent();
        hashmap = (HashMap<String, String>) intent.getSerializableExtra("info");

        danishName.setText(hashmap.get("NameDanish"));
        englishName.setText(hashmap.get("NameEnglish"));
        longitude.setText("Longitude");
        latitude.setText("Latitude");
        date.setText(hashmap.get("Created"));

    }
}
