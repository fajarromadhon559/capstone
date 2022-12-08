package com.example.capstonepesaing.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransaksiResponse(

	@field:SerializedName("TransaksiResponse")
	val transaksiResponse: List<TransaksiResponseItem?>? = null
) : Parcelable

@Parcelize
data class TransaksiResponseItem(

	@field:SerializedName("transaksi_total")
	val transaksiTotal: String? = null,

	@field:SerializedName("transaksi_id")
	val transaksiId: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("transaksi_tgl")
	val transaksiTgl: String? = null
) : Parcelable
