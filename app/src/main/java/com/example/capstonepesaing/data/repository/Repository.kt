package com.example.capstonepesaing.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstonepesaing.data.UserPreference
import com.example.capstonepesaing.data.model.Barang
import com.example.capstonepesaing.data.remote.ApiService
import com.example.capstonepesaing.data.response.BarangResponse
import com.example.capstonepesaing.data.response.ResultResponse
import com.example.capstonepesaing.requirement.wrapEspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val preference: UserPreference
    ){

    private val _userLogin = MutableLiveData<ResultResponse>()
    val userLogin: LiveData<ResultResponse> = _userLogin

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _listBarang = MutableLiveData<List<Barang>>()
    val listBarang: LiveData<List<Barang>> = _listBarang


    suspend fun loginUser(email: String, password: String){
        wrapEspressoIdlingResource {
            _isLoading.value = true
            apiService.loginUser(email, password)
                .enqueue(object : Callback<BarangResponse> {
                    override fun onResponse(
                        call: Call<BarangResponse>,
                        response: Response<BarangResponse>
                    ) {
                        if (response.isSuccessful) {
                            _listBarang.postValue(response.body()?.listStory)
                        }
                    }

                    override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                        Log.d(RETROFIT_TAG, t.message.toString())
                    }

                })
        }

    }


}