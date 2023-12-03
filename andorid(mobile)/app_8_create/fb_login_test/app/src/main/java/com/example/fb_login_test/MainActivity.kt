package com.example.fb_login_test

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val btn = findViewById<Button>(R.id.noEmailLoginBtn)
        btn.setOnClickListener{

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "signInAnonymously:success")
                        val user = auth.currentUser
                        //updateUI(user)

                        Log.d("MainActivity", user!!.uid) //익명유저로 로그인하면 UID가 생성된다. 이를 출력한다는 것.

                    } else {
                        // If sign in fails, display a message to the user.
                        //Log.w(TAG, "signInAnonymously:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        //updateUI(null)
                    }
                }

        }

    }
}