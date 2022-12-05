package com.example.capstonepesaing.view_pedagang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstonepesaing.databinding.ActivityDetailBarangBinding

class DetailBarang : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBarangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}