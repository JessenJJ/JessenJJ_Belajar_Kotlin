package com.example.jessenjj_kotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jessenjj_kotlin.presentation.LoginActivity.Companion.KEY_ADDRESS
import com.example.jessenjj_kotlin.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val getEmail = intent.getStringExtra(KEY_ADDRESS)
        binding.tvLabelEmail.text = getEmail

        binding.vComponentTopbar.tvTitle.text = "Profile Features"
        binding.vComponentTopbar.ivBack.setOnClickListener{
            onBackPressed()
        }






    }
}