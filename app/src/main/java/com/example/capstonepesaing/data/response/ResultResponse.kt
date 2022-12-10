package com.example.capstonepesaing.data.response

import com.google.gson.annotations.SerializedName
import retrofit2.Callback

data class ResultResponse(

	@field:SerializedName("RESPONSE")
	val response: String? = null
	) {
	fun enqueue(any: Any) {
		TODO("Not yet implemented")
	}
}