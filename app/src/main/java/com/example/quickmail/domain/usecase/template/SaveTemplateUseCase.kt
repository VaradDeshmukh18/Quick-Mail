package com.example.quickmail.domain.usecase.template

import com.example.quickmail.domain.model.EmailTemplate
import com.example.quickmail.domain.repository.TemplateRepository
import javax.inject.Inject

class SaveTemplateUseCase @Inject constructor(
    private val repository: TemplateRepository
) {
    suspend operator fun invoke(template: EmailTemplate) {
        repository.insertTemplate(template)
    }
}