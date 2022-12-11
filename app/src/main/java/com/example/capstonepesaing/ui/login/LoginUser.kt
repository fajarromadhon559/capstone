package com.example.capstonepesaing.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityLoginUserBinding
import com.example.capstonepesaing.ui.home.MainActivity
import com.example.capstonepesaing.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginUser : AppCompatActivity() {
    private lateinit var binding : ActivityLoginUserBinding
    private val viewModelViewModel by viewModels<LoginViewModel>()

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Login"

        mAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener{
            loginFirebase()
        }
    }

    private fun loginFirebase(){
        val email = binding.tvEmail.text.toString()
        val pass = binding.tvPassword.text.toString()

        if(email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Email format is not valid", Toast.LENGTH_SHORT).show()
        }else if(email.isNotBlank() && pass.isNotBlank()){
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    })
                    Toast.makeText(this,"Login success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Email or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this,"Email or Password Cannot be blank", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun login() {
//        val factory = ViewModelFactory.getInstance(this)
//        val loginVm: LoginViewModel by viewModels { factory }
//        val email = binding.loginEmail.text.toString().trim()
//        val password = binding.loginPassword.text.toString().trim()
//        loginVm.loginUser(email, password).observe(this) { result ->
//            if (result != null) {
//                when (result) {
//                    is Result.Loading -> {
//                        binding.progressBar.visible()
//                    }
//                    is Result.Success -> {
//                        binding.progressBar.gone()
//                        val idUser = result.data.loginResult.userId
//                        val name = result.data.loginResult.name
//                        val token = result.data.loginResult.token
//
//                        sharedPref = SharedPreferences(this)
//                        sharedPref.saveDataUser(idUser, name, token, true)
//                        Intent(this@LoginActivity, MainActivity::class.java).also {
//                            startActivity(it)
//                            finish()
//                        }
//                    }
//                    is Result.Error -> {
//                        binding.progressBar.gone()
//                        Toast.makeText(
//                            this,
//                            "failed login" + result.error,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        }
//    }

//    private fun editTextFilled() {
//        binding.loginEmail.onTextChanged { enableEditText() }
//        binding.loginPassword.onTextChanged { enableEditText() }
//
//    }
//
//    private fun enableEditText() {
//        val email = binding.loginEmail.text.toString().trim()
//        val password = binding.loginPassword.text.toString().trim()
//        binding.btnLogin.isEnabled =
//            email.isNotEmpty() && emailValid(email) && password.length > 6 && password.isNotEmpty()
//    }

}