package com.example.capstonepesaing.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.capstonepesaing.databinding.ActivityRegisterBinding
import com.example.capstonepesaing.ui.home.MainActivity
import com.example.capstonepesaing.ui.login.LoginUser
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Register"

       mAuth = FirebaseAuth.getInstance()

        setAllClickListener()
    }

    private fun registerFirebase(){
        val email = binding.tvEmail.text.toString()
        val pass = binding.tvPassword.text.toString()
        val name = binding.tvName.text.toString()
        val phone = binding.tvPhone.text.toString()

        if(email.isNotBlank() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Email format is not valid", Toast.LENGTH_SHORT).show()
        }else if(email.isNotBlank() && pass.isNotBlank()){
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    startActivity(Intent(this, FinishRegister::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    })
                    Toast.makeText(this,"Register success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Email or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this,"Email or Password Cannot be blank", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAllClickListener(){
        binding.btnRegister.setOnClickListener{
//            register()
            registerFirebase()
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