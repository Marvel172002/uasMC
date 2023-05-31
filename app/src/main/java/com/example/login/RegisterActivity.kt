package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()



            buttonregis.setOnClickListener {

                val email: String = editemail2.text.toString().trim()
                val pass: String = editPassword2.text.toString().trim()

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

                if (pass.isEmpty() || pass.length < 6) {
                    editpass.error = "kbfjsb"
                    editpass.requestFocus()
                    return@setOnClickListener
                }

                registerUser(email,pass)
            }
        }



    private fun registerUser(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if(it.isSuccessful){
                    Intent (this,MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()}}}}