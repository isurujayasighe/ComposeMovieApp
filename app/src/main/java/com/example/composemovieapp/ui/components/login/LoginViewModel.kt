package com.example.composemovieapp.ui.components.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemovieapp.repository.LoginRepository
import com.example.composemovieapp.repository.model.LoginCredentials
import com.example.composemovieapp.repository.model.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
): ViewModel(){


    fun login(loginCredentials: LoginCredentials){

        viewModelScope.launch {
            val loginResponse: Flow<LoginResponse> = loginRepository.login(loginCredentials)
        }
    }



}