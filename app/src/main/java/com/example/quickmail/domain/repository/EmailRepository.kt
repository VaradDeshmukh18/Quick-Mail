package com.example.quickmail.domain.repository



interface EmailRepository {
    fun sendEmail(
        senderEmail: String,
        senderPassword: String,
        recipientEmail: String,
        subject: String,
        body: String,
        attachmentPath: String? = null
    ): Boolean
}