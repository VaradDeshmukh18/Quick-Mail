package com.example.quickmail.domain.model

data class EmailTemplate(
    val id: Int = 0,
    val subject: String,
    val body: String
)