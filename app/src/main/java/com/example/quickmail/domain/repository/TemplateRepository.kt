package com.example.quickmail.domain.repository


import com.example.quickmail.data.local.EmailTemplateDao
import com.example.quickmail.data.local.EmailTemplateEntity
import com.example.quickmail.domain.model.EmailTemplate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TemplateRepository {
    fun getAllTemplates(): Flow<List<EmailTemplate>>
    suspend fun insertTemplate(template: EmailTemplate)
    suspend fun deleteTemplate(template: EmailTemplate)
}