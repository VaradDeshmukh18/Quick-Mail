package com.example.quickmail.domain.usecase.template

import com.example.quickmail.domain.model.EmailTemplate
import com.example.quickmail.domain.repository.TemplateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTemplatesUseCase @Inject constructor(
    private val repository: TemplateRepository
) {
    operator fun invoke(): Flow<List<EmailTemplate>> {
        return repository.getAllTemplates()
    }
}