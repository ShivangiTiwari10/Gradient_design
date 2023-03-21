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
    }
}