package com.example.capstonepesaing.view_pedagang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstonepesaing.R
import com.example.capstonepesaing.databinding.ActivityMainVpBinding

class MainVP : AppCompatActivity() {
    private lateinit var binding : ActivityMainVpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainVpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  untuk nginput barang
        binding.btnInpBarang.setOnClickListener{
            val i = Intent(this, InputBarang::class.java)
            startActivity(i)
        }
    }
}