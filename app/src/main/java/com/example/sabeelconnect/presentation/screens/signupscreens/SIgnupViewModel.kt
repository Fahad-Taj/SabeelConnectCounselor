package com.example.sabeelconnect.presentation.screens.signupscreens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.models.SignUp.SignupResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response


class SignupViewModel : ViewModel() {
    private val _response = MutableStateFlow<Response<SignupResponse>?>(null)
    val response: StateFlow<Response<SignupResponse>?> = _response
    fun signup(signupRequest: SignupRequest) {
        Log.e("SignUp Request", signupRequest.toString())
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.signup(signupRequest)
                _response.value = result
                if (result.isSuccessful) {
                    access_token = result.body()?.data?.access_token
                }
            } catch (e: Exception) {
                Log.e("SignUp Exception", e.message ?: "Unknown exception")
            }
        }
    }
}
