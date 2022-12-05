package com.example.capstonepesaing.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityPreLoginBinding
import com.example.capstonepesaing.ui.login.LoginUser

class PreLogin : AppCompatActivity() {
    private lateinit var binding : ActivityPreLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toRegister.setOnClickListener{
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
//        buat ke login
        binding.toLogin.setOnClickListener{
            val i = Intent(this, LoginUser::class.java)
            startActivity(i)
        }
    }
}