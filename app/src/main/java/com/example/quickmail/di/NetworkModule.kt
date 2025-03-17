package com.example.quickmail.di

import com.example.quickmail.data.remote.SmtpEmailSender
import com.example.quickmail.domain.repository.EmailRepository
import com.example.quickmail.domain.repository.EmailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideEmailSender(): SmtpEmailSender = SmtpEmailSender

    @Provides
    @Singleton
    fun provideEmailRepository(): EmailRepository = EmailRepositoryImpl()
}