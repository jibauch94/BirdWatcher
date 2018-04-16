package com.example.jibba.birdwatcher

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

import com.google.firebase.auth.FirebaseAuth

class MyPageActivityKotlin : AppCompatActivity() {

    private var myObsBtn: Button? = null
    private var allObsBtn: Button? = null
    private var createObsBtn: Button? = null
    private var signOutBtn: Button? = null
    private var allBirdsBtn: Button? = null

    private var firebaseAuth: FirebaseAuth? = null

    private val buttonClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.signOutBtn -> signOut()

            R.id.myObsBtn -> {
                val myObsIntent = Intent(this@MyPageActivityKotlin, CreateObsActivity::class.java)
                startActivity(myObsIntent)
                val allBirdsIntent = Intent(this@MyPageActivityKotlin, BirdsCatalogActivity::class.java)
                startActivity(allBirdsIntent)
            }

            R.id.allBirdsBtn -> {
                val allBirdsIntent = Intent(this@MyPageActivityKotlin, BirdsCatalogActivity::class.java)
                startActivity(allBirdsIntent)
            }
        }//Toast.makeText(LoginActivity.this, "You are trying to Login...", Toast.LENGTH_SHORT).show();
        //Intent myMenuIntent = new Intent(LoginActivity.this, PostedActivity.class);
        //startActivity(myMenuIntent);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        // Firebase declaration stuff
        firebaseAuth = FirebaseAuth.getInstance()

        myObsBtn = findViewById(R.id.myObsBtn)
        myObsBtn!!.setOnClickListener(buttonClickListener)
        allObsBtn = findViewById(R.id.allObsBtn)
        createObsBtn = findViewById(R.id.createObsBtn)
        signOutBtn = findViewById(R.id.signOutBtn)
        signOutBtn!!.setOnClickListener(buttonClickListener)
        allBirdsBtn = findViewById(R.id.allBirdsBtn)
        allBirdsBtn!!.setOnClickListener(buttonClickListener)

    }

    private fun signOut() {
        firebaseAuth!!.signOut()
        val signoutIntent = Intent(this@MyPageActivityKotlin, MainActivity::class.java)
        startActivity(signoutIntent)

    }
}
