package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

public class BirdsCatalogCreateObs2Activity extends AppCompatActivity {

    private ImageView birdIV;
    private TextView birdName, birdCreated;
    private String url;
    private String name;
    private String created;
    private Button makeObsBtn;
    private HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_catalog_create_obs2);

        birdIV = findViewById(R.id.birdIV);
        birdName = findViewById(R.id.birdName);
        birdCreated = findViewById(R.id.birdCreated);
        makeObsBtn = findViewById(R.id.makeObsBtn);
        makeObsBtn.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        hashMap = (HashMap<String, String>)intent.getSerializableExtra("bird");
        Log.v("HashMapTest", hashMap.get("PhotoUrl"));
        url = hashMap.get("PhotoUrl");
        name = hashMap.get("NameDanish");
        birdName.setText(name);
        created = hashMap.get("Created");
        birdCreated.setText(created);

        Glide.with(this).load(url).into(birdIV);

    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.makeObsBtn:
                    Intent makeObsIntent = new Intent(BirdsCatalogCreateObs2Activity.this, CreateObsActivity.class);
                    makeObsIntent.putExtra("info", hashMap);
                    startActivity(makeObsIntent);

            }
        }
    };
}
