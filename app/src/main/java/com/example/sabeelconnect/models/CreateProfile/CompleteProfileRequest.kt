package com.example.sabeelconnect.models.CreateProfile

data class CompleteProfileRequest(
    val academic_education: String,
    val age: Int,
    val country: String,
    val gender: String,
    val languages_spoken: String,
    val name: String,
    val preferred_language: String,
    val religion: String,
    val religious_education: String,
    val specialty_areas: String,
    val state: String,
    val email: String
)