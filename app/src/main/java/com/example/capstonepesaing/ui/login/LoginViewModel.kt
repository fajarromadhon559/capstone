package com.example.capstonepesaing.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.capstonepesaing.data.repository.Repository
import com.example.capstonepesaing.data.response.ResultResponse
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    val userLogin: LiveData<ResultResponse>()

    fun loginUser(email: String, password: String){

    }
}