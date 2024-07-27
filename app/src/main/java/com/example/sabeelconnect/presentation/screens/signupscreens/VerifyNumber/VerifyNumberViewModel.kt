package com.example.sabeelconnect.presentation.screens.signupscreens.VerifyNumber

import android.util.Log
import androidx.compose.runtime.mutableStateOf
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

    var awaitingResponse = mutableStateOf(false)

    fun verify_number(otp: String) {
        viewModelScope.launch {
            awaitingResponse.value = true
            try {
                val bearerToken = "Bearer $access_token"
                val result = RetrofitInstance.api.verifynumber(bearerToken, VerifyNumberRequest(otp))
                _response.value = result

                Log.e("Response from verify number", result.toString())
                Log.e("Response from verify Number - 1", result.message())
                Log.e("Check verify number function", bearerToken.toString() + "  " + otp)

                if (result.isSuccessful) {
                    Log.e("Response from verify Number - 2", result.message())
                }
            }
            catch (e: Exception) {
                // Handle exception
            }
            awaitingResponse.value = false
        }
    }

}