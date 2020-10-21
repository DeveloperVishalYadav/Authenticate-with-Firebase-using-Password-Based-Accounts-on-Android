package com.example.jwtauthfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class DashboardActivity : AppCompatActivity() {
    private lateinit var Logout:Button
    private lateinit var auth:FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        Logout=findViewById(R.id.logout)
        auth=FirebaseAuth.getInstance();

        Logout.setOnClickListener{
            auth.signOut()
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }

        }
    }
