package com.example.sabeelconnect.presentation.screens.loginscreens.Login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    // Login Info Variables
    var username = mutableStateOf("")
    var password = mutableStateOf("")

    // Generic function which will update a state variable when it's value is changed
    fun <T> updateState(state: MutableState<T>, newValue: T) {
        state.value = newValue
    }

    var awaitingResponse = mutableStateOf(false)

    fun login(username: String, password: String) {

        viewModelScope.launch {
            awaitingResponse.value = true
            try {
                val result = RetrofitInstance.api.login(username, password)
                _response.value = result
                if (result.isSuccessful) {

                }
                Log.e("Login Response", response.value?.body().toString())
                Log.e("Login Response", response.value?.errorBody().toString())
                Log.e("Login Response", response.value?.code().toString())

            } catch (e: Exception) {
                // Handle exception
            }
            awaitingResponse.value = false
        }
    }
}