package com.example.quickmail.domain.repository

import com.example.quickmail.data.local.EmailTemplateDao
import com.example.quickmail.domain.model.EmailTemplate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
    private val dao: EmailTemplateDao
) : TemplateRepository {

    override fun getAllTemplates(): Flow<List<EmailTemplate>> {
        return dao.getAllTemplates().map { entities ->
            entities.map { EmailTemplate(it.id, it.subject, it.body) }
        }
    }

    override suspend fun insertTemplate(template: EmailTemplate) {
        dao.insertTemplate(com.example.quickmail.data.local.EmailTemplateEntity(template.id, template.subject, template.body))
    }

    override suspend fun deleteTemplate(template: EmailTemplate) {
        dao.deleteTemplate(com.example.quickmail.data.local.EmailTemplateEntity(template.id, template.subject, template.body))
    }
}