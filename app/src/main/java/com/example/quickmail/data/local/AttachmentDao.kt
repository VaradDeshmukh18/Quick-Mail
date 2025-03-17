package com.example.quickmail.data.local

import androidx.room.*

@Dao
interface AttachmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttachment(attachment: AttachmentEntity)

    @Query("SELECT * FROM attachments WHERE emailId = :emailId")
    suspend fun getAttachmentsByEmail(emailId: Long): List<AttachmentEntity>

    @Query("DELETE FROM attachments WHERE id = :id")
    suspend fun deleteAttachment(id: Long)
}