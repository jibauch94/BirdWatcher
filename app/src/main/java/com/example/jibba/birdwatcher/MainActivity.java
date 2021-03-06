package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private String TAG;


//Firebase stuff

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase decleration
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            Log.d(TAG, "onCreate: " + firebaseAuth.getCurrentUser().getEmail());
            Intent autoLoginIntent = new Intent(MainActivity.this, MyPageActivity.class);
            autoLoginIntent.putExtra("userID", firebaseAuth.getCurrentUser().getUid());
            startActivity(autoLoginIntent);
        }

        loginButton = findViewById(R.id.loginBtn);
        registerButton = findViewById(R.id.regBtn);

        loginButton.setOnClickListener(buttonClickListener);
        registerButton.setOnClickListener(buttonClickListener);

    }

    // This is the ButtonClickListener, it listens for multiple buttons. just give the case, the button id from xml.
    private View.OnClickListener buttonClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

            switch(view.getId()) {
                case R.id.loginBtn:
                    //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    //finish();
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    //toastMessage("Height: " +height + "\nWidht: " + width);

                    break;
                case R.id.regBtn:
                    //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    //finish();
                    Intent registerIntent = new Intent(MainActivity.this, CreateUserActivity.class);
                    startActivity(registerIntent);

                    break;
            }
        }
    };

}
