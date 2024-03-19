package com.example.jessenjj_kotlin.presentation

import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {


    private lateinit var binding:  ActivityRegisterBinding

    private var defaultPasswordVisibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRegister()

    binding.ivPassword.setOnClickListener{
        defaultPasswordVisibility = !defaultPasswordVisibility

        if(defaultPasswordVisibility){
            binding.ivPassword.setImageResource(R.drawable.red_eye)
            binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT

        }else{
            binding.ivPassword.setImageResource(R.drawable.fish_eye)
            binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        }
    }


    }

    private fun handleRegister(){

    val btnRegister = binding.btnRegister

    val etName = binding.etName
    val nameValue =  etName.text

    val etEmail = binding.etEmail
    val emailValue =  etEmail.text

    val etPassword = binding.etPassword
    val passwordValue =  etPassword.text

    binding.btnRegister.setOnClickListener{

        if(nameValue.isEmpty()||passwordValue.isEmpty()||emailValue.isEmpty()){
            showToast("harap lengkapi data")
        }else{
            Toast.makeText(this,"Halo $nameValue selamat datang di aplikasi saya",Toast.LENGTH_SHORT).show()

        }
    }




    }
        private fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }


}