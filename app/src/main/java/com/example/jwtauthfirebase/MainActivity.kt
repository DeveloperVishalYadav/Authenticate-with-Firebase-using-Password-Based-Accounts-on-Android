package com.example.jwtauthfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister1: Button
    private lateinit var TvLogin: TextView
    private lateinit var auth:FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth=FirebaseAuth.getInstance();

        etEmail =findViewById(R.id.editEmail)
        etPassword =findViewById(R.id.editPassword)
        btnRegister1 =findViewById(R.id.btnRegister)

        TvLogin=findViewById(R.id.tvLogin)

        btnRegister1.setOnClickListener{
            var email =etEmail.text.toString().trim()
            var password =etPassword.text.toString().trim()
            if(email.isNotEmpty()|| password.isNotEmpty()) {
                createuser(email,password)
                var intent =Intent(this,DashboardActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext," Please Provide Email and Password....",Toast.LENGTH_LONG).show()
            }
        }

        TvLogin.setOnClickListener{
            var intent =Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun createuser(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            task-> if(task.isSuccessful){
            Toast.makeText(applicationContext," Data Send Successfully....",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext,"Error !!"+task.exception,Toast.LENGTH_LONG).show()
        }

        }
    }

    override fun onStart() {
        super.onStart()
        val user =auth.currentUser
        if (user !=null){
            var intent =Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    }
