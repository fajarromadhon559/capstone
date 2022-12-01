package com.example.capstonepesaing.ui.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstonepesaing.R
import com.example.capstonepesaing.data.local.Category
import com.example.capstonepesaing.databinding.CategoryItemsBinding

class MainCategoryRecyclerAdapter(private val listCategory : ArrayList<Category>): RecyclerView.Adapter<MainCategoryRecyclerAdapter.MainCategoryHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class MainCategoryHolder(private val binding: CategoryItemsBinding): RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgIconCategory
        val contentTxt = binding.tvIconCategory
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryHolder {
        val binding = CategoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainCategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: MainCategoryHolder, position: Int) {
        val (txt, photo) = listCategory[position]
        holder.contentTxt.text = txt
        holder.img.setImageResource(photo)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listCategory[holder.adapterPosition], holder)
        }
    }

    override fun getItemCount(): Int = listCategory.size

    interface OnItemClickCallback {
        fun onItemClicked(category: Category, holder: MainCategoryHolder)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}