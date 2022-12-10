package com.example.capstonepesaing.data.remote

import com.example.capstonepesaing.data.response.BarangResponse
import com.example.capstonepesaing.data.response.UserListResponse
import com.example.capstonepesaing.data.response.ResultResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @GET("get_user.php")
    suspend fun getAllUser(
    ): UserListResponse

    @GET("get_barang.php")
    suspend fun getAllBarang(
    ) : BarangResponse

    @GET("get_all_location.php")
    suspend fun getAllLocation()

    @GET("login.php")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ) : ResultResponse

}