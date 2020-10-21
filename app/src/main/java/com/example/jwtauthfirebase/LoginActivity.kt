package com.example.jwtauthfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var TvRegister:TextView
    private lateinit var BtnLogin:Button
    private lateinit var TextInputEmail:EditText
    private lateinit var TextInputPassword:EditText

    private lateinit var auth:FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        TvRegister=findViewById(R.id.tvRegister)

        BtnLogin=findViewById(R.id.btnLogin)
        TextInputEmail=findViewById(R.id.textInputEmail)
        TextInputPassword=findViewById(R.id.textInputPassword)

        auth=FirebaseAuth.getInstance();

        BtnLogin.setOnClickListener{
            var email=TextInputEmail.text.toString().trim()
            var password=TextInputPassword.text.toString().trim()

            if(email.isNotEmpty() || password.isNotEmpty()){
                signinuser(email,password)
                Toast.makeText(applicationContext,"Loged in.....",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Please Vaild Enter Details.....",Toast.LENGTH_LONG).show()
            }

        }

        TvRegister.setOnClickListener{

            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun signinuser(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task->
            if(task.isSuccessful){
                var intent=Intent(this,DashboardActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext,"Error !!"+task.exception,Toast.LENGTH_LONG).show()
            }

        }

    }
}