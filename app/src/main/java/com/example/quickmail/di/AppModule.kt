package com.example.quickmail.di

import android.content.Context
import androidx.room.Room
import com.example.quickmail.data.local.AttachmentDao
import com.example.quickmail.data.local.EmailDatabase
import com.example.quickmail.data.local.EmailTemplateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule