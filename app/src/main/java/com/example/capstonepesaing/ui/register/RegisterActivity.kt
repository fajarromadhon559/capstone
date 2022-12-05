package com.example.capstonepesaing.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.capstonepesaing.databinding.ActivityRegisterBinding
import com.example.capstonepesaing.ui.login.LoginUser

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            val i = Intent(this, FinishRegister::class.java)
            startActivity(i)
        }

    }

}