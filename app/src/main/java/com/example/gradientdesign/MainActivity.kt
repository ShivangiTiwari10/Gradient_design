package com.example.gradientdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.gradientdesign.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()

        binding.btnSignup.setOnClickListener {

            signUpUser()
        }
        binding.tvRedirectLogin.setOnClickListener {
            val intent = Intent(this, AdvanceRegisterScreen::class.java)
            startActivity(intent)
        }


    }

    private fun signUpUser() {

        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val passward = binding.etPassward.text.toString()
        val confirmPassword = binding.etConferm.text.toString()
        // check pass
        if (name.isEmpty() || email.isEmpty() || passward.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()

            Log.d("auth", "$email,$passward")
            return
        }
        if (passward != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }

        auth.createUserWithEmailAndPassword(email, passward).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
            }
        }

    }
}