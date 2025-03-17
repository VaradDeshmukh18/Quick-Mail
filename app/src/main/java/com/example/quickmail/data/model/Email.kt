package com.example.quickmail.data.model

data class Email(
    val recipient: String,
    val subject: String,
    val body: String,
    val attachmentPath: String? = null
)