package com.example.capstonepesaing.ui.home

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonepesaing.R
import com.example.capstonepesaing.data.ListAdapter
import com.example.capstonepesaing.data.local.Category
import com.example.capstonepesaing.databinding.ActivityMainBinding
import com.example.capstonepesaing.ui.barang.add.AddBarangActivity

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Category>()
    private lateinit var rvCategory: RecyclerView
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.title = "Home"

        rvCategory = binding.rvCategory
        rvCategory.setHasFixedSize(true)
        list.addAll(listCategory)
        showRecyclerList()

        pedagang()
        warung()
        setupViewModel()
    }

    private fun pedagang(){
        binding.btnPedagang.setOnClickListener{
            val intent = Intent(this, AddBarangActivity::class.java)
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity as Activity).toBundle())
        }
    }

    private fun warung(){
        binding.btnWarung.setOnClickListener{
            val intent = Intent(this, AddBarangActivity::class.java)
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity as Activity).toBundle())
        }
    }

    private fun setupViewModel(){

    }

    private val listCategory: ArrayList<Category>
        get() {
            val categoryName = resources.getStringArray(R.array.category_name)
            val categoryImg = resources.obtainTypedArray(R.array.category_img)

            val list = ArrayList<Category>()
            for (i in categoryName.indices) {
                val category = Category(categoryName[i],categoryImg.getResourceId(i,-1),)
                list.add(category)
                Log.e("ListCategory","${categoryName[i]}, ${categoryImg.getResourceId(i,-1)}")
            }
            return list
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvCategory.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }
        val listCategoryAdapter = MainCategoryRecyclerAdapter(list)
        rvCategory.adapter = listCategoryAdapter

        listCategoryAdapter.setOnItemClickCallback(object : MainCategoryRecyclerAdapter.OnItemClickCallback {
            override fun onItemClicked(
                category: Category,
                holder: MainCategoryRecyclerAdapter.MainCategoryHolder
            ) {
                showSelectedCategory(category)
            }
        })
    }

    private fun showSelectedCategory(category: Category) {
        Toast.makeText(this, "Kamu memilih " + category.category, Toast.LENGTH_SHORT).show()
    }
}