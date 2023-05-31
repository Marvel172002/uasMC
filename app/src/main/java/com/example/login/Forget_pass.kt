package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_pass.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class Forget_pass : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)

        auth = FirebaseAuth.getInstance()

        btnlp.setOnClickListener {

            val email: String = editemail2.text.toString().trim()

            if (email.isEmpty()) {
                editemail.error = "doo"
                editemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editemail.error = "doo"
                editemail.requestFocus()
                return@setOnClickListener
            }

            forgetUser(email)
        }
    }



    private fun forgetUser(email:String) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener {
            if(it.isSuccessful){
                Intent (this,MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }else{
                Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()}}}}
