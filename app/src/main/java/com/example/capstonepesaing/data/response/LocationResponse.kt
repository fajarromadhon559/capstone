package com.example.capstonepesaing.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationResponse(

	@field:SerializedName("LocationResponse")
	val locationResponse: List<LocationResponseItem?>? = null
) : Parcelable

@Parcelize
data class LocationResponseItem(

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("long")
	val jsonMemberLong: String? = null
) : Parcelable
