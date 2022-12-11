package com.example.capstonepesaing.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityFinishRegisterBinding
import com.example.capstonepesaing.ui.home.MainActivity
import com.example.capstonepesaing.ui.login.LoginUser

class FinishRegister : AppCompatActivity() {
    private lateinit var binding : ActivityFinishRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //Jadi misal si user udah selesai regist gak perlu ke login lagi, langsung ke main
        binding.btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }
    }
}