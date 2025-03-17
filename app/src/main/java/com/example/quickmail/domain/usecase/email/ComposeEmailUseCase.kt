package com.example.quickmail.domain.usecase.email

import com.example.quickmail.data.model.Email
import javax.inject.Inject

class ComposeEmailUseCase @Inject constructor() {
    operator fun invoke(
        recipient: String,
        subject: String,
        body: String,
        attachmentPath: String? = null
    ): Email {
        return Email(recipient, subject, body, attachmentPath)
    }
}