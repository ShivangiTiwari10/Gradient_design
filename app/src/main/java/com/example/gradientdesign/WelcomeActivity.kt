package com.example.gradientdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding
            : ActivityWelcomeBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(SignInActivity.KEY2)
        val email = intent.getStringExtra(SignInActivity.KEY1)
        val id = intent.getStringExtra(SignInActivity.KEY3)


        binding.tvWelcome.text = "Name: $name"
        binding.tvMail.text = "Email: $email"
        binding.tvUnique.text = "UniqueId: $id"

    }
}