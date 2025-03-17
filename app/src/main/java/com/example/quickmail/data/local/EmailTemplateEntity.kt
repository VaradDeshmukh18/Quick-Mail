package com.example.quickmail.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "email_templates")
data class EmailTemplateEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subject: String,
    val body: String
)