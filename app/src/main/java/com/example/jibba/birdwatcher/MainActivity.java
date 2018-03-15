package com.example.jibba.birdwatcher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button registerButton;
    int height;
    int width;
    String str;

//Firebase stuff

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase decleration
        firebaseAuth = FirebaseAuth.getInstance();
        
        mAuthListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                FirebaseUser fbUser = firebaseAuth.getCurrentUser();
                if (fbUser != null)
                {
                    // toastMessage("Successfully signed in with " + fbUser.getEmail());
                    Toast.makeText(MainActivity.this, "Du er logget ind: " + fbUser.getEmail(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Could display not signed in. But might cause toasting issues...
                }
            }
        };



        loginButton = (Button) findViewById(R.id.loginBtn);
        registerButton = (Button) findViewById(R.id.regBtn);

        loginButton.setOnClickListener(buttonClickListener);
        registerButton.setOnClickListener(buttonClickListener);



    }

    // This is the ButtonClickListener, it listens for multiple buttons. just give the case, the button id from xml.
    private View.OnClickListener buttonClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {

            height = getWindowManager().getDefaultDisplay().getHeight();
            width = getWindowManager().getDefaultDisplay().getWidth();
            str = "Height: " + height + ", Width: " + width;

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
