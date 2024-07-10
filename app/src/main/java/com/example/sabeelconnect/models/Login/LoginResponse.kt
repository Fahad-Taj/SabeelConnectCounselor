package com.example.sabeelconnect.models.Login

data class LoginResponse(
    val access_token: String,
    val message: String,
    val refresh_token: String,
    val role: String,
    val token_type: String
)