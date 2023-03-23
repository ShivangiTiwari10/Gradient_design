package com.example.gradientdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gradientdesign.databinding.ActivityAdvanceRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class AdvanceRegisterScreen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityAdvanceRegisterScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdvanceRegisterScreenBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            login()

        }

        binding.tvRedirectSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // using finish() to end the activity
            finish()
        }
    }

    private fun login() {
        val email = binding.etEmailAddress.text.toString()
        val pass = binding.etPassword.text.toString()
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn also see new-signup", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,newSignUpScreen::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }
}
