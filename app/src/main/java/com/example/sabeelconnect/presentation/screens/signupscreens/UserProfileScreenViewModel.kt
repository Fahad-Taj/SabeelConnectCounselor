package com.example.sabeelconnect.presentation.screens.signupscreens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileRequest
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileResponse
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.models.SignUp.SignupResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response


class UserProfileViewModel : ViewModel() {
    private val _response = MutableStateFlow<Response<CompleteProfileResponse>?>(null)
    val response: StateFlow<Response<CompleteProfileResponse>?> = _response

    fun create_profile(createProfileRequest: CompleteProfileRequest) {
        Log.e("Create Profile Request", createProfileRequest.toString())
        viewModelScope.launch {
            try {
                val bearerToken = "Bearer ${access_token}"
                val result = RetrofitInstance.api.complete_profile(bearerToken, createProfileRequest)
                Log.e("Create Profile Response - 2", result.body().toString())

                _response.value = result
                if (result.isSuccessful) {
                    Log.e("Create Profile Request is successful", "Success")
                }
            } catch (e: Exception) {
                Log.e("SignUp Exception", e.message ?: "Unknown exception")
            }
        }
    }
}