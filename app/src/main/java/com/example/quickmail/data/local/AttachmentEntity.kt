package com.example.quickmail.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attachments")
data class AttachmentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val emailId: Long,
    val filePath: String
)