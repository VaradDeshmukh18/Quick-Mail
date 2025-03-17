package com.example.quickmail.di

import android.content.Context
import androidx.room.Room
import com.example.quickmail.data.local.AttachmentDao
import com.example.quickmail.data.local.EmailDatabase
import com.example.quickmail.data.local.EmailTemplateDao
import com.example.quickmail.domain.repository.TemplateRepository
import com.example.quickmail.domain.repository.TemplateRepositoryImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): EmailDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            EmailDatabase::class.java,
            "email_db"
        ).build()
    }

    @Provides
    fun provideEmailTemplateDao(db: EmailDatabase): EmailTemplateDao = db.emailTemplateDao()

    @Provides
    fun provideAttachmentDao(db: EmailDatabase): AttachmentDao = db.attachmentDao()

    @Provides
    @Singleton
    fun provideTemplateRepository(dao: EmailTemplateDao): TemplateRepository {
        return TemplateRepositoryImpl(dao)
    }
}