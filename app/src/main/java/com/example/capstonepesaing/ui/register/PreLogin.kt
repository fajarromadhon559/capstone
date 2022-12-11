package com.example.capstonepesaing.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityPreLoginBinding
import com.example.capstonepesaing.ui.home.MainActivity
import com.example.capstonepesaing.ui.login.LoginUser
import com.google.firebase.auth.FirebaseAuth

class PreLogin : AppCompatActivity() {
    private lateinit var binding : ActivityPreLoginBinding
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        binding.toRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }

        binding.toLogin.setOnClickListener{
            startActivity(Intent(this, LoginUser::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
        }

        checkSession()
    }

    private fun checkSession(){
        if(mAuth.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}