package com.example.sabeelconnect.presentation.screens.signupscreens.SignUp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.models.SignUp.SignupResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response


class SignupViewModel : ViewModel() {

    // Personal info variables
    var name =   mutableStateOf("")
    var password =   mutableStateOf("")
    var email =   mutableStateOf("")
    var phoneNumber =   mutableStateOf("")
    var confirmPassword =   mutableStateOf("")

    var buttonClicked =   mutableStateOf(false)
    var countryCode =  mutableStateOf("")

    // Generic function which will update a state variable when it's value is changed
    fun <T> updateState(state: MutableState<T>, newValue: T) {
        state.value = newValue
    }

    var awaitingResponse = mutableStateOf(false)

    private val _response = MutableStateFlow<Response<SignupResponse>?>(null)
    val response: StateFlow<Response<SignupResponse>?> = _response
    fun signup() {
        val signupRequest = SignupRequest(
            username = name.value,
            email = email.value,
            mobile_number = "+91${phoneNumber.value}",
            password = password.value,
            role = "Counselor",
            confirm_password = confirmPassword.value

        )
        Log.e("SignUp Request", signupRequest.toString())
        viewModelScope.launch {
            awaitingResponse.value = true
            try {
                val result = RetrofitInstance.api.signup(signupRequest)
                _response.value = result
                if (result.isSuccessful) {
                    access_token = result.body()?.data?.access_token
                }
            } catch (e: Exception) {
                Log.e("SignUp Exception", e.message ?: "Unknown exception")
            }
            awaitingResponse.value = false
        }
    }
}
