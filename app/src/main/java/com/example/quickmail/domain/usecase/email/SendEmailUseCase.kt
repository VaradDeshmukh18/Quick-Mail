package com.example.quickmail.domain.usecase.email

import com.example.quickmail.domain.repository.EmailRepository
import javax.inject.Inject

class SendEmailUseCase @Inject constructor(
    private val repository: EmailRepository
) {
    operator fun invoke(
        senderEmail: String,
        senderPassword: String,
        recipientEmail: String,
        subject: String,
        body: String,
        attachmentPath: String? = null
    ): Boolean {
        return repository.sendEmail(senderEmail, senderPassword, recipientEmail, subject, body, attachmentPath)
    }
}