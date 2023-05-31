package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_pass.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        lupapass.setOnClickListener {
            Intent(this, Forget_pass::class.java).also {
                startActivity(it)
            }
        }


        textRegister.setOnClickListener {
            Intent (this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        buttonLogin.setOnClickListener {

        val email: String = editemail.text.toString().trim()
        val pass: String = editpass.text.toString().trim()

        if (email.isEmpty()) {
            editemail.error = "Masukkan Email"
            editemail.requestFocus()
            return@setOnClickListener
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editemail.error = "Masukkan Email"
            editemail.requestFocus()
            return@setOnClickListener
        }

        if (pass.isEmpty() || pass.length < 6) {
            editpass.error = "Pass Error"
            editpass.requestFocus()
            return@setOnClickListener
        }

        loginUser(email,pass)
    }
}

private fun loginUser(email: String, pass: String) {
    auth.signInWithEmailAndPassword(email,pass)
        .addOnCompleteListener {
            if(it.isSuccessful){
                Intent (this,Selamat_datang::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }else{
                Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
}
}
