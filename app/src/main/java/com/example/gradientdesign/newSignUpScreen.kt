package com.example.gradientdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivityNewSignUpScreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class newSignUpScreen : AppCompatActivity() {
    lateinit var database: DatabaseReference

    private lateinit var binding: ActivityNewSignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewSignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.materialButton.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassward.text.toString()
            val uniqueId = binding.etUniqeId.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
        }
    }
}