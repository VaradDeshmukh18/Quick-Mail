package com.example.quickmail.domain.repository

import com.example.quickmail.data.remote.SmtpEmailSender
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor() : EmailRepository {
    override fun sendEmail(
        senderEmail: String,
        senderPassword: String,
        recipientEmail: String,
        subject: String,
        body: String,
        attachmentPath: String?
    ): Boolean {
        return SmtpEmailSender.sendEmail(senderEmail, senderPassword, recipientEmail, subject, body, attachmentPath)
    }
}