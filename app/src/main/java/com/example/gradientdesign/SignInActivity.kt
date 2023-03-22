package com.example.gradientdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}