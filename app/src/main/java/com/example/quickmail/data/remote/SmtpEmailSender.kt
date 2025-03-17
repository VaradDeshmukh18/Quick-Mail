package com.example.quickmail.data.remote



import java.util.*
import javax.activation.DataHandler
import javax.activation.DataSource
import javax.activation.FileDataSource
import javax.mail.*
import javax.mail.internet.*


object SmtpEmailSender {

    fun sendEmail(
        senderEmail: String,
        senderPassword: String,
        recipientEmail: String,
        subject: String,
        body: String,
        attachmentPath: String? = null
    ): Boolean {
        val properties = Properties().apply {
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.port", "587")
        }

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(senderEmail, senderPassword)
            }
        })

        return try {
            val message = MimeMessage(session).apply {
                setFrom(InternetAddress(senderEmail))
                setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail))
                setSubject(subject)

                val multipart = MimeMultipart()

                // Body part
                val textPart = MimeBodyPart().apply {
                    setText(body)
                }
                multipart.addBodyPart(textPart)

                // Attachment part
                attachmentPath?.let {
                    val attachmentPart = MimeBodyPart()
                    val source: DataSource = FileDataSource(it)
                    attachmentPart.dataHandler = DataHandler(source)
                    attachmentPart.fileName = source.name
                    multipart.addBodyPart(attachmentPart)
                }

                setContent(multipart)
            }

            Transport.send(message)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}