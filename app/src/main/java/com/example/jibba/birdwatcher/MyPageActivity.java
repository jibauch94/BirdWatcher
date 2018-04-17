package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MyPageActivity extends AppCompatActivity {

    private Button myObsBtn, allObsBtn, createObsBtn, signOutBtn, allBirdsBtn;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        // Firebase declaration stuff
        firebaseAuth = FirebaseAuth.getInstance();

        myObsBtn = findViewById(R.id.myObsBtn);
        myObsBtn.setOnClickListener(buttonClickListener);
        allObsBtn = findViewById(R.id.allObsBtn);
        createObsBtn = findViewById(R.id.createObsBtn);
        signOutBtn = findViewById(R.id.signOutBtn);
        signOutBtn.setOnClickListener(buttonClickListener);
        allBirdsBtn = findViewById(R.id.allBirdsBtn);
        allBirdsBtn.setOnClickListener(buttonClickListener);

    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.signOutBtn:
                    signOut();
                    //Toast.makeText(MyPageActivity.this, "You are logged out...", Toast.LENGTH_SHORT).show();
                    //Intent myMenuIntent = new Intent(LoginActivity.this, PostedActivity.class);
                    //startActivity(myMenuIntent);
                    break;

                case R.id.myObsBtn:
                    Intent myObsIntent = new Intent(MyPageActivity.this, CreateObsActivity.class);
                    startActivity(myObsIntent);

                case R.id.allBirdsBtn:
                    Intent allBirdsIntent = new Intent(MyPageActivity.this, BirdsCatalogActivity.class);
                    startActivity(allBirdsIntent);

            }
        }
    };

    private void signOut(){
        firebaseAuth.signOut();
        Intent signoutIntent = new Intent(MyPageActivity.this, MainActivity2.class);
        startActivity(signoutIntent);

    }
}
