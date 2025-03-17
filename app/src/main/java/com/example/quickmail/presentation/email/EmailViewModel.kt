package com.example.quickmail.presentation.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmail.domain.usecase.email.SendEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(
    private val sendEmailUseCase: SendEmailUseCase
) : ViewModel() {

    private var isEmailSent: Boolean = false
        private set

    fun sendEmail(
        senderEmail: String,
        senderPassword: String,
        recipientEmail: String,
        subject: String,
        body: String,
        attachmentPath: String? = null,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            isEmailSent = sendEmailUseCase(senderEmail, senderPassword, recipientEmail, subject, body, attachmentPath)
            onResult(isEmailSent)
        }
    }
}
