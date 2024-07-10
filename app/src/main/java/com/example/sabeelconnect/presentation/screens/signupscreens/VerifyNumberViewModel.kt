package com.example.sabeelconnect.presentation.screens.signupscreens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberRequest
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class VerifyNumberViewModel: ViewModel(){

    private val _response = MutableStateFlow<Response<VerifyNumberResponse>?>(null)
    val response: StateFlow<Response<VerifyNumberResponse>?> = _response

    fun verify_number(otp: String) {
        viewModelScope.launch {
            try {
                val bearerToken = "Bearer $access_token"
                Log.e("Check verify number function", bearerToken.toString() + "  " + otp)
                val result = RetrofitInstance.api.verifynumber(bearerToken, VerifyNumberRequest(otp))
                _response.value = result
                Log.e("Response from verify Number - 1", result.message())
                if (result.isSuccessful) {
                    Log.e("Response from verify Number - 2", result.message())
                }
            }
            catch (e: Exception) {
                // Handle exception
            }
        }
    }

}