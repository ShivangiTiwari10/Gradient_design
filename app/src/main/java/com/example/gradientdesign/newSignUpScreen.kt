package com.example.gradientdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || uniqueId.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, email, password, uniqueId)
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(uniqueId).setValue(user).addOnSuccessListener {

                    binding.etName.text?.clear()
                    binding.etEmail.text?.clear()
                    binding.etPassward.text?.clear()
                    binding.etUniqeId.text?.clear()

                    Toast.makeText(this, "User logged In", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
}