package com.example.capstonepesaing.data.remote

import com.example.capstonepesaing.data.response.BarangResponse
import com.example.capstonepesaing.data.response.UserResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("get_user.php")
    suspend fun userLogin(
        @Field("email") email: String
    ): UserResponse

    @GET("show_user.php")
    suspend fun getAllUser(
    ) : UserResponse

    @GET("get_barang.php")
    suspend fun getAllBarang(
    ) : BarangResponse

}