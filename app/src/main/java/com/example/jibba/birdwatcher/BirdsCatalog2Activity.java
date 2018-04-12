package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

public class BirdsCatalog2Activity extends AppCompatActivity {

    private ImageView birdIV;
    private TextView birdName, birdCreated;
    private String url;
    private String name;
    private String created;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_catalog2);

        birdIV = findViewById(R.id.birdIV);
        birdName = findViewById(R.id.birdName);
        birdCreated = findViewById(R.id.birdCreated);

        Intent intent = getIntent();
        HashMap<String, String> hashMap = (HashMap<String, String>)intent.getSerializableExtra("bird");
        Log.v("HashMapTest", hashMap.get("PhotoUrl"));
        url = hashMap.get("PhotoUrl");
        name = hashMap.get("NameDanish");
        birdName.setText(name);
        created = hashMap.get("Created");
        birdCreated.setText(created);

        Glide.with(this).load(url).into(birdIV);

    }
}
