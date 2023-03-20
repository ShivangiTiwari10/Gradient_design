package com.example.gradientdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradientdesign.databinding.ActivityAdvanceRegisterScreenBinding

class AdvanceRegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityAdvanceRegisterScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdvanceRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}