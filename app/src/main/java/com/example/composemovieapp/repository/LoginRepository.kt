package com.example.composemovieapp.repository

import androidx.annotation.WorkerThread
import com.example.composemovieapp.repository.model.LoginCredentials
import com.example.composemovieapp.repository.model.LoginResponse
import com.example.composemovieapp.repository.remote.BackendAPIClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val backendAPIClient: BackendAPIClient
) {

    @WorkerThread
    fun login(loginCredentials: LoginCredentials) = flow {
        backendAPIClient.login(loginCredentials)
            .suspendOnSuccess {
                emit(data)
            }
            .onFailure {
                onError {
                    message()
                }
            }
    }.flowOn(Dispatchers.IO)
}