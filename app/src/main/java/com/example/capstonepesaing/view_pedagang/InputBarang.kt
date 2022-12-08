package com.example.capstonepesaing.view_pedagang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import com.example.capstonepesaing.R

class InputBarang : AppCompatActivity() {
    private lateinit var listKt : Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_barang)

//buat dropdown nya aj dah bisa
        listKt = findViewById(R.id.spinner_barang)
        listKt = findViewById(R.id.spinner_satuan)

//        ini bermaksud pas kategori diklik munculin toast text, cuman gak bisa
//        listKt.setOnClickListener{
//            val toast = Toast.makeText(this,"kamu memilih kategori${listKt.selectedItem}", Toast.LENGTH_SHORT)
//            toast.show()
//        }
    }
}