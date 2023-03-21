package com.example.gradientdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivityNewSignUpScreenBinding

class newSignUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivityNewSignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewSignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.materialButton.setOnClickListener {
            val name = binding.etName.text
            val email = binding.etEmail.text
            val password = binding.etPassward.text
            val uniqueId = binding.etUniqeId.text
        }
    }
}