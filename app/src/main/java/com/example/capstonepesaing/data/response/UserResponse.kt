package com.example.capstonepesaing.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(

	@field:SerializedName("UserResponse")
	val userResponse: List<UserResponseItem?>? = null
) : Parcelable

@Parcelize
data class UserResponseItem(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("user_gambar")
	val userGambar: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("no_hp")
	val noHp: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_kategori")
	val userKategori: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("user_saldo")
	val userSaldo: String? = null
) : Parcelable
