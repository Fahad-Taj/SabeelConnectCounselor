package com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileRequest
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileResponse
import com.example.sabeelconnect.models.GetCounselorInfo.GetCounselorInfoResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response


class UserProfileViewModel : ViewModel() {
    private val _response = MutableStateFlow<Response<CompleteProfileResponse>?>(null)
    val response: StateFlow<Response<CompleteProfileResponse>?> = _response

    private val _infoResponse = MutableStateFlow<Response<GetCounselorInfoResponse>?>(null)
    val infoResponse: StateFlow<Response<GetCounselorInfoResponse>?> = _infoResponse

    // State variables
    // Personal details
    var name = mutableStateOf("")
    var phoneNumber = mutableStateOf("")

    var email = mutableStateOf("")
    var gender = mutableStateOf("Male")

    // Convert to int while sending to API
    var age = mutableStateOf("22")

    // Religious variables
    var religion = mutableStateOf("Islam")
    var religiousEducation = mutableStateOf("Aalema")

    // Academic variables
    var academicEducation = mutableStateOf("10th")
    var specialtyAreas = mutableStateOf("General")

    // Language variables
    var preferredLanguages = mutableStateOf("English")
    var languagesSpoken = mutableStateOf("English")

    // Location variables
    var country = mutableStateOf("Aruba")
    var state = mutableStateOf("Canillo")

    // Generic function which will update a state variable when it's value is changed
    fun <T> updateState(state: MutableState<T>, newValue: T) {
        state.value = newValue
    }

    // Coroutine variables
    // Used to check if the name, email and phone number are loading from api endpoint
    var _isLoading = MutableStateFlow(true)
    var isLoading: StateFlow<Boolean> = _isLoading

    // Used to check the status of the request that is sent to the api endpoint
    var awaitingResponse = mutableStateOf(false)

    // Sends api request for completing the counselor profile
    fun submitButtonClicked(){
        viewModelScope.launch {
            awaitingResponse.value = true
            try {
                val bearerToken = "Bearer $access_token"
                val request = CompleteProfileRequest(
                    academic_education = academicEducation.value,
                    age = age.value.toInt(),
                    country = country.value,
                    gender = gender.value,
                    languages_spoken = languagesSpoken.value,
                    name = name.value,
                    preferred_language = preferredLanguages.value,
                    religion = religion.value,
                    religious_education = religiousEducation.value,
                    specialty_areas = specialtyAreas.value,
                    state = state.value,
                    email = email.value
                )
                val result = RetrofitInstance.api.complete_profile(bearerToken, request)
                _response.value = result
            } catch (e: Exception){
                e.printStackTrace()
            }
            awaitingResponse.value = false
        }
    }

    // Sends api request to get the basic details of counselor
    fun get_counselor_info(){
        val bearer_token = "Bearer $access_token"
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = RetrofitInstance.api.get_counselor_info(bearer_token)
                name.value = result.body()?.data?.user?.username.toString()
                phoneNumber.value = result.body()?.data?.user?.mobile_number.toString()
            } catch(e: Exception){
                e.printStackTrace()
            }
            _isLoading.value = false
        }

    }

}