package com.example.sabeelconnect.api

import com.example.sabeelconnect.models.CreateProfile.CompleteProfileRequest
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileResponse
import com.example.sabeelconnect.models.Login.LoginResponse
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.models.SignUp.SignupResponse
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberRequest
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT


interface SabeelApi {
    @POST("/api/v1/auth/signup")
    suspend fun signup(@Body request: SignupRequest): Response<SignupResponse>

    @POST("/api/v1/auth/verify_otp")
    suspend fun verifynumber(
        @Header("Authorization") token: String?,
        @Body request: VerifyNumberRequest
    ): Response<VerifyNumberResponse>

    @FormUrlEncoded
    @POST("/api/v1/auth/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : Response<LoginResponse>

    @PUT("/api/v1/counselors/complete_profile")
    suspend fun complete_profile(
        @Header("Authorization") token: String?,
        @Body request: CompleteProfileRequest
    ): Response<CompleteProfileResponse>
}