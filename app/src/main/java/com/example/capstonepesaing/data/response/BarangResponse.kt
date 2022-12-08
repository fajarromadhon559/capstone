package com.example.capstonepesaing.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BarangResponse(

	@field:SerializedName("BarangResponse")
	val barangResponse: List<BarangResponseItem?>? = null
) : Parcelable

@Parcelize
data class BarangResponseItem(

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("satuan")
	val satuan: String? = null,

	@field:SerializedName("barang_harga")
	val barangHarga: String? = null,

	@field:SerializedName("barang_gambar")
	val barangGambar: String? = null,

	@field:SerializedName("nama_barang")
	val namaBarang: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("barang_id")
	val barangId: String? = null,

	@field:SerializedName("barang_kategori")
	val barangKategori: String? = null
) : Parcelable
