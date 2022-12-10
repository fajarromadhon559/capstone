package com.example.capstonepesaing.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityLoginUserBinding
import com.example.capstonepesaing.ui.home.MainActivity

class LoginUser : AppCompatActivity() {
    private lateinit var binding : ActivityLoginUserBinding
    private val viewModelViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Login"

        binding.btnLogin.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun login() {
        val factory = ViewModelFactory.getInstance(this)
        val loginVm: LoginViewModel by viewModels { factory }
        val email = binding.loginEmail.text.toString().trim()
        val password = binding.loginPassword.text.toString().trim()
        loginVm.loginUser(email, password).observe(this) { result ->
            if (result != null) {
                when (result) {
                    is Result.Loading -> {
                        binding.progressBar.visible()
                    }
                    is Result.Success -> {
                        binding.progressBar.gone()
                        val idUser = result.data.loginResult.userId
                        val name = result.data.loginResult.name
                        val token = result.data.loginResult.token

                        sharedPref = SharedPreferences(this)
                        sharedPref.saveDataUser(idUser, name, token, true)
                        Intent(this@LoginActivity, MainActivity::class.java).also {
                            startActivity(it)
                            finish()
                        }
                    }
                    is Result.Error -> {
                        binding.progressBar.gone()
                        Toast.makeText(
                            this,
                            "failed login" + result.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun editTextFilled() {
        binding.loginEmail.onTextChanged { enableEditText() }
        binding.loginPassword.onTextChanged { enableEditText() }

    }

    private fun enableEditText() {
        val email = binding.loginEmail.text.toString().trim()
        val password = binding.loginPassword.text.toString().trim()
        binding.btnLogin.isEnabled =
            email.isNotEmpty() && emailValid(email) && password.length > 6 && password.isNotEmpty()
    }

}