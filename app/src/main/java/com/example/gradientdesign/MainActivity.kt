package com.example.gradientdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, AdvanceRegisterScreen::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}