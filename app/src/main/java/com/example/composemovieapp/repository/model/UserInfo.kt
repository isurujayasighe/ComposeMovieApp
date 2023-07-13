package com.example.composemovieapp.repository.model

data class UserInfo(
    val fullName: String,
    val needToResetPassword: Boolean,
    val email: String,
    val orgCode: String
)
