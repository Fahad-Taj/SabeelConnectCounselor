package com.example.sabeelconnect.models.SignUp

import com.example.sabeelconnect.models.SignUp.SignUpData

data class SignupResponse(
    val status: String,
    val data: SignUpData,
    val message: String
)
