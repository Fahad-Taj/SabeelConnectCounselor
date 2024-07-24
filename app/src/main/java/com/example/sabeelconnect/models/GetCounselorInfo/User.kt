package com.example.sabeelconnect.models.GetCounselorInfo

data class User(
    val academic_education: String,
    val age: Int,
    val country: String,
    val dp: String,
    val email: String,
    val gender: String,
    val id: Int,
    val id_document: String,
    val is_email_verified: Boolean,
    val is_human_verified: Boolean,
    val is_mobile_verified: Boolean,
    val languages_spoken: String,
    val mobile_number: String,
    val preferred_language: String,
    val qual_document: String,
    val religion: String,
    val religious_education: String,
    val specialty_areas: String,
    val state: String,
    val username: String
)