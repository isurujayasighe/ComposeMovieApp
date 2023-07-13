package com.example.composemovieapp.repository.model

data class LoginResponse(
    val token: String,
    val expiration: String,
    val userInfo: UserInfo
)
