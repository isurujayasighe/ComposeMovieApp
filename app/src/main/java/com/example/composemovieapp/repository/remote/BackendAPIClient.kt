package com.example.composemovieapp.repository.remote

import com.example.composemovieapp.repository.model.LoginCredentials
import com.example.composemovieapp.repository.model.LoginResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class BackendAPIClient @Inject constructor(
    private  val backendAPI: BackendAPI) {

    suspend fun login(loginCredentials: LoginCredentials): ApiResponse<LoginResponse> {
        return backendAPI.login(loginCredentials)
    }
}