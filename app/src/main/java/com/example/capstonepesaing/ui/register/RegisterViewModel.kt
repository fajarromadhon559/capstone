package com.example.capstonepesaing.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.capstonepesaing.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    val isLoading: LiveData<Boolean> =

    fun registerUser(name: String, email: String, username: String){

    }
}