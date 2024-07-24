package com.example.sabeelconnect.presentation.screens.signupscreens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sabeelconnect.api.RetrofitInstance
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.CredentialsVerification.IdDocumentResponse
import com.example.sabeelconnect.models.SignUp.SignupResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File

class CredentialsVerificationViewModel : ViewModel(){
    private val _response1 = MutableStateFlow<Response<IdDocumentResponse>?>(null)
    val response1: StateFlow<Response<IdDocumentResponse>?> = _response1

    private val _response2 = MutableStateFlow<Response<IdDocumentResponse>?>(null)
    val response2: StateFlow<Response<IdDocumentResponse>?> = _response2

    fun IdUpload(file: File){
        viewModelScope.launch {
            try {
                val multipartBodyBuilder = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                val bearerToken = "Bearer $access_token"
                multipartBodyBuilder.addFormDataPart("id_document", file.name,
                    file.asRequestBody("multipart/form-data".toMediaTypeOrNull()))

                val result = RetrofitInstance.api.id_document(bearerToken, multipartBodyBuilder.build())
                _response1.value = result
                Log.e("Id 1", file.absolutePath)
            } catch (e: Exception){
                Log.e("IdUpload Exception", e.printStackTrace().toString())
            }
        }
    }

    fun QualUpload(file: File){
        viewModelScope.launch {
            try {

                val multipartBodyBuilder = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)

                val bearerToken = "Bearer $access_token"
                multipartBodyBuilder.addFormDataPart("qual_document", file.name,
                    file.asRequestBody("multipart/form-data".toMediaTypeOrNull()))
                Log.e("Token", bearerToken)

                val result = RetrofitInstance.api.qual_document(bearerToken, multipartBodyBuilder.build())

                _response2.value = result

                Log.e("Qual Upload Request body", RequestBody.toString())
                Log.e("Qual upload token", bearerToken)
                Log.e("Qual Upload Result", result.toString())
                Log.e("Id 2", file.absolutePath)


            } catch (e: Exception){
                Log.e("IdUpload Exception", e.printStackTrace().toString())
            }

        }
    }
}