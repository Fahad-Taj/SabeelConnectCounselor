package com.example.sabeelconnect.presentation.screens.loginscreens

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.models.Login.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginScreenViewModel: ViewModel(){

    private val _response = MutableStateFlow<Response<LoginResponse>?>(null)
    val response: StateFlow<Response<LoginResponse>?> = _response

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.login(username, password)
                _response.value = result
                if (result.isSuccessful) {

                }

            } catch (e: Exception) {
                // Handle exception
            }
        }
    }

}