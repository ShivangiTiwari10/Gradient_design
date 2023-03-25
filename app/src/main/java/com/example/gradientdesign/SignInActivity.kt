package com.example.gradientdesign

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gradientdesign.databinding.ActivitySignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    lateinit var database: DatabaseReference

    companion object {
        const val KEY1 = "com.example.gradient design.SignInActivity.email"
        const val KEY2 = "com.example.gradient design.SignInActivity.name"
        const val KEY3 = "com.example.gradient design.SignInActivity.uniqueId"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {

            val uniqueId = binding.enterId.text.toString()
            if (uniqueId.isNotEmpty()) {
                getData(uniqueId)
            } else {
                Toast.makeText(this, "Please enter user id", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getData(uniqueId: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(uniqueId).get().addOnSuccessListener {


            if (binding.checkbox.isChecked) {
                Toast.makeText(this, "u accepted term and condition", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Please accept term and condition", Toast.LENGTH_SHORT).show()
                binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
            }
            if (it.exists()) {

                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value


                val advanced = Intent(this, WelcomeActivity::class.java)
                advanced.putExtra(KEY1, email.toString())
                advanced.putExtra(KEY2, name.toString())
                advanced.putExtra(KEY3, userId.toString())
                startActivity(advanced)
            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }

        }

    }

}

