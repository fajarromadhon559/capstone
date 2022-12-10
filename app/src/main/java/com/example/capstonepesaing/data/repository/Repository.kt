package com.example.capstonepesaing.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.capstonepesaing.data.UserPreference
import com.example.capstonepesaing.data.model.Barang
import com.example.capstonepesaing.data.remote.ApiService
import com.example.capstonepesaing.data.response.ResultResponse
import com.example.capstonepesaing.requirement.RETROFIT_TAG
import com.example.capstonepesaing.requirement.wrapEspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val preference: UserPreference
    ){

    private val _userLogin = MutableLiveData<LoginResponse>()
    val userLogin: LiveData<LoginResponse> = _userLogin

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    private val _listBarang = MutableLiveData<List<Barang>>()
    val listBarang: LiveData<List<Barang>> = _listBarang


//    @OptIn(ExperimentalPagingApi::class)
//    fun getBarang(): LiveData<PagingData<Barang>>{
//        return Pager(
//            config = PagingConfig(pageSize = 3),
//        )
//
//    }

    fun login(email: String, password: String){
        wrapEspressoIdlingResource {
            _isLoading.value = true
            apiService.loginUser(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        _isLoading.value = false
                        if (response.isSuccessful) {
                            _toastMessage.value = response.body()?.message
                            _userLogin.value = response.body()?.loginResult
                            Log.d(RETROFIT_TAG, response.body()?.message.toString())
                            Log.d(RETROFIT_TAG, response.body()?.loginResult?.email ?: "email")
                            Log.d(RETROFIT_TAG, response.body()?.loginResult?.password ?: "password")
                            Log.d(RETROFIT_TAG, response.body()?.loginResult?.userId ?: "userId")
                        }
                        if (!response.isSuccessful) {
                            _toastMessage.value = response.message()
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        _toastMessage.value = t.message
                        _isLoading.value = false
                        Log.d(RETROFIT_TAG, t.message.toString())
                    }

                })
        }

    }


    fun register(name: String, email: String, password: String): LiveData<ResultResponse> = liveData{
            emit(ResultResponse.Loading)
        try {
            val response = apiService.register(
                name, email, password
            )
            if (response.error){
                emit(ResultResponse.Error(response.message))
            } else {
                emit(ResultResponse.Error())
            }
        }

    }


}