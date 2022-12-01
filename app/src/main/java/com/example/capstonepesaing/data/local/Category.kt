package com.example.capstonepesaing.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    var category: String,
    var img: Int,
) : Parcelable
