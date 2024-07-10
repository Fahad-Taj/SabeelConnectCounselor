package com.example.sabeelconnect.models.SignUp

data class SignupRequest(
    val username: String,
    val email: String,
    val mobile_number: String,
    val role: String,
    val password: String,
    val confirm_password: String
)
