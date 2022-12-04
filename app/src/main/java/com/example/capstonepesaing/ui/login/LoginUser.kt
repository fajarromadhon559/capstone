package com.example.capstonepesaing.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityLoginUserBinding
import com.example.capstonepesaing.ui.home.MainActivity

class LoginUser : AppCompatActivity() {
    private lateinit var binding : ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}