package com.example.composemovieapp.repository.remote

import com.example.composemovieapp.repository.model.LoginCredentials
import com.example.composemovieapp.repository.model.LoginResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface BackendAPI {

    @POST("/api/Account/mobileLogin")
    suspend fun login(loginCredentials: LoginCredentials): ApiResponse<LoginResponse>

}