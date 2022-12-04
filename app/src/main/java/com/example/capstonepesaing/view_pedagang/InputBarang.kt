package com.example.capstonepesaing.view_pedagang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.capstonepesaing.R
import com.anthonyfdev.dropdownview.DropDownView

class InputBarang : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_barang)

        val dropDownView = findViewById<DropDownView>(R.id.dp_kategori)
        val collapsedView : View = LayoutInflater.from(this ).inflate(R.layout.header,null, false)
        val expandedView : View = arrayOf(R.array.dropDown_kategori)

        dropDownView.setHeaderView(collapsedView)
        dropDownView.setExpandedView(expandedView)

    }
}