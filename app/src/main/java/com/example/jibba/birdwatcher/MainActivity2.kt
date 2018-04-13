package com.example.jibba.birdwatcher

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button

import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private var loginButton: Button? = null
    private var registerButton: Button? = null
    private val TAG: String? = null


    //Firebase stuff

    private var firebaseAuth: FirebaseAuth? = null
    private val mAuthListener: FirebaseAuth.AuthStateListener? = null

    // This is the ButtonClickListener, it listens for multiple buttons. just give the case, the button id from xml.
    private val buttonClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.loginBtn -> {
                //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                //finish();
                val loginIntent = Intent(this@MainActivity2, LoginActivity::class.java)
                startActivity(loginIntent)
            }
            R.id.regBtn -> {
                //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                //finish();
                val registerIntent = Intent(this@MainActivity2, CreateUserActivity::class.java)
                startActivity(registerIntent)
            }
        }//toastMessage("Height: " +height + "\nWidht: " + width);
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        //firebase decleration
        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth!!.currentUser != null) {
            Log.d(TAG, "onCreate: " + firebaseAuth!!.currentUser!!.email!!)
            val autoLoginIntent = Intent(this@MainActivity2, MyPageActivity::class.java)
            autoLoginIntent.putExtra("userID", firebaseAuth!!.currentUser!!.uid)
            startActivity(autoLoginIntent)
        }

        loginButton = findViewById(R.id.loginBtn)
        registerButton = findViewById(R.id.regBtn)

        loginButton!!.setOnClickListener(buttonClickListener)
        registerButton!!.setOnClickListener(buttonClickListener)

    }

}
