package com.example.quickmail.di

import com.example.quickmail.data.remote.FirebaseAuthService
import com.example.quickmail.data.remote.SmtpEmailSender
import com.example.quickmail.domain.repository.AuthRepository
import com.example.quickmail.domain.repository.AuthRepositoryImpl
import com.example.quickmail.domain.repository.EmailRepository
import com.example.quickmail.domain.repository.EmailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthService(): FirebaseAuthService = FirebaseAuthService()

    @Provides
    @Singleton
    fun provideAuthRepository(authService: FirebaseAuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }
}