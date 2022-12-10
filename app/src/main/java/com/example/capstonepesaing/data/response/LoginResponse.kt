package com.example.capstonepesaing.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(

	@field:SerializedName("LoginResponse")
	val loginResponse: List<LoginResponseItem?>? = null
) : Parcelable

@Parcelize
data class LoginResponseItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("user_kategori")
	val userKategori: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null
) : Parcelable
