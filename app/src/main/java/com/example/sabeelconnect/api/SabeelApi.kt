package com.example.sabeelconnect.api

import com.example.sabeelconnect.models.CreateProfile.CompleteProfileRequest
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileResponse
import com.example.sabeelconnect.models.CredentialsVerification.IdDocumentResponse
import com.example.sabeelconnect.models.GetCounselorInfo.GetCounselorInfoResponse
import com.example.sabeelconnect.models.Login.LoginResponse
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.models.SignUp.SignupResponse
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberRequest
import com.example.sabeelconnect.models.VerifyNumber.VerifyNumberResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part


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

    @PUT("/api/v1/counselors/id_document")
    suspend fun id_document(
        @Header("Authorization") token: String?,
        @Body requestBody: RequestBody,
    ): Response<IdDocumentResponse>

    @PUT("/api/v1/counselors/qual_document")
    suspend fun qual_document(
        @Header("Authorization") token: String?,
        @Body requestBody: RequestBody,
    ): Response<IdDocumentResponse>

    @GET("/api/v1/counselors/complete_profile_info")
    suspend fun get_counselor_info(
        @Header("Authorization") token: String?
    ): Response<GetCounselorInfoResponse>


}