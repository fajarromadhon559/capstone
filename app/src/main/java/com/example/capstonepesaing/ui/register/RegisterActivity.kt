package com.example.capstonepesaing.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.capstonepesaing.databinding.ActivityRegisterBinding
import com.example.capstonepesaing.ui.login.LoginUser

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "register"

        action()
//        binding.btnRegister.setOnClickListener{
//            val i = Intent(this, FinishRegister::class.java)
//            startActivity(i)
//        }

    }

    private fun action(){
        binding.btnRegister.setOnClickListener{
            register()
        }
    }

    private fun register(){
        val name = binding.tvName.text.toString().trim()
        val email = binding.tvEmail.text.toString().trim()
        val password = binding.tvPassword.text.toString().trim()
        viewModel.registerUser(name, email, password)

        val intent = Intent(this, LoginUser::class.java)
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this@RegisterActivity as Activity).toBundle())
        finish()
    }

}