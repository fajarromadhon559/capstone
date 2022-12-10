package com.example.capstonepesaing.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.capstonepesaing.data.repository.Repository
import com.example.capstonepesaing.data.response.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    val userLogin: LiveData<LoginResponse> = repository.userLogin
    val isLoading: LiveData<Boolean> = repository.isLoading
    val toastMessage: LiveData<String> = repository.toastMessage

    fun loginUser(email: String, password: String) = repository.login(email, password)
}