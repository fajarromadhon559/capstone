package com.example.capstonepesaing.ui.home

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonepesaing.R
import com.example.capstonepesaing.data.local.Category
import com.example.capstonepesaing.databinding.ActivityLoginUserBinding
import com.example.capstonepesaing.databinding.ActivityMainBinding
import com.example.capstonepesaing.ui.category.AllCategory
import com.example.capstonepesaing.ui.map.MapActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener


class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Category>()
    private lateinit var rvCategory: RecyclerView
//    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
//        supportActionBar?.title = "Home"

        binding.btnAllCategory.setOnClickListener{
            val i = Intent(this,AllCategory::class.java)
            startActivity(i)
        }

        rvCategory = binding.rvCategory
        rvCategory.setHasFixedSize(true)
        list.addAll(listCategory)
        showRecyclerList()

        bottomNavClickListener()

//        pedagang()
//        warung()
//        setupViewModel()
    }

    private fun bottomNavClickListener(){
        binding.navBottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.cart -> {
                    Toast.makeText(this,"Coming Soon", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.riwayat -> {
                    Toast.makeText(this,"Coming Soon", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.keluar -> {
                    showLogoutAlertDialog()
                    true
                }
                else -> {
                    super.onOptionsItemSelected(item)
                }
            }
            true
        }
    }

    private fun showLogoutAlertDialog(){
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to Logout from current user ?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Logout", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Logout")
            // show alert dialog
            alert.show()
    }

    private fun pedagang(){
        binding.btnPedagang.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity as Activity).toBundle())
        }
    }

    private fun warung(){
        binding.btnWarung.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity as Activity).toBundle())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                true
            }
            R.id.cart -> {
                Toast.makeText(this,"Coming Soon", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.riwayat -> {
                Toast.makeText(this,"Coming Soon", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.keluar -> {
                Toast.makeText(this,"Keluar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

//    private fun setupViewModel(){
//
//    }

    private val listCategory: ArrayList<Category>
        get() {
            val categoryName = resources.getStringArray(R.array.category_name)
            val categoryImg = resources.obtainTypedArray(R.array.category_img)

            val list = ArrayList<Category>()
            for (i in categoryName.indices) {
                val category = Category(categoryName[i], categoryImg.getResourceId(i, -1))
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