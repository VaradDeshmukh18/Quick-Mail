package com.example.quickmail.presentation.templates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmail.domain.model.EmailTemplate
import com.example.quickmail.domain.usecase.template.DeleteTemplateUseCase
import com.example.quickmail.domain.usecase.template.GetTemplatesUseCase
import com.example.quickmail.domain.usecase.template.SaveTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val getTemplatesUseCase: GetTemplatesUseCase,
    private val saveTemplateUseCase: SaveTemplateUseCase,
    private val deleteTemplateUseCase: DeleteTemplateUseCase
) : ViewModel() {

    private val _templates = MutableStateFlow<List<EmailTemplate>>(emptyList())
    val templates: StateFlow<List<EmailTemplate>> = _templates.asStateFlow()

    init {
        loadTemplates()
    }

    fun loadTemplates() {
        viewModelScope.launch {
            getTemplatesUseCase().collect { _templates.value = it }
        }
    }

    fun saveTemplate(subject: String, body: String) {
        viewModelScope.launch {
            saveTemplateUseCase(EmailTemplate(subject = subject, body = body))
            loadTemplates()
        }
    }

    fun deleteTemplate(template: EmailTemplate) {
        viewModelScope.launch {
            deleteTemplateUseCase(template)
            loadTemplates()
        }
    }
}