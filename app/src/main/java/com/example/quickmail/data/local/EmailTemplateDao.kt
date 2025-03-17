package com.example.quickmail.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EmailTemplateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTemplate(template: EmailTemplateEntity)

    @Query("SELECT * FROM email_templates")
    fun getAllTemplates(): Flow<List<EmailTemplateEntity>>

    @Query("DELETE FROM email_templates WHERE id = :id")
    suspend fun deleteTemplate(id: EmailTemplateEntity)
}