package com.example.composemovieapp.dagger

import com.example.composemovieapp.repository.LoginRepository
import com.example.composemovieapp.repository.remote.BackendAPIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(backendAPIClient: BackendAPIClient): LoginRepository {
        return LoginRepository(backendAPIClient)
    }
}