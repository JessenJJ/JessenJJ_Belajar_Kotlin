package com.example.jessenjj_kotlin.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jessenjj_kotlin.databinding.ActivityLoginBinding
import com.example.jessenjj_kotlin.utils.SharePrefHelper
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharePrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)
        checkToken()


        val tvRegister = binding.tvRegister
        tvRegister.setOnClickListener {
            handleRegister()
        }

        binding.cbShowPassword.setOnClickListener {
            val cbShowPassword = binding.cbShowPassword
            if (cbShowPassword.isChecked) {
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }


        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.isEmpty().not() && binding.etPassword.text.isEmpty().not()) {
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                intentTo()
            } else {
                Toast.makeText(this, "lengkapi email dan password", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun intentTo(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun checkToken() {
        val getToken = sharePref.getToken()
        if (getToken.isNotEmpty()) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }


    private fun handleRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

//    private fun handleLogin() {
//        val etEmail = binding.etEmail
//        val emailValue = etEmail.text
//
//        val etPassword = binding.etPassword
//        val passwordValue = etPassword.text
//
//
//        if (passwordValue.isEmpty() || emailValue.isEmpty()) {
//            showToast("harap lengkapi data")
//        } else {
//            val intent = Intent(this, HomeActivity::class.java)
//            intent.putExtra(KEY_ADDRESS, emailValue.toString())
//            startActivity(intent)
//            Toast.makeText(
//                this,
//                "Halo $emailValue selamat datang di aplikasi saya",
//                Toast.LENGTH_SHORT
//            ).show()
//
//        }
//    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"

    }

}