package com.example.quickmail.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EmailTemplateEntity::class, AttachmentEntity::class], version = 1)
abstract class EmailDatabase : RoomDatabase() {
    abstract fun emailTemplateDao(): EmailTemplateDao
    abstract fun attachmentDao(): AttachmentDao
}


//@Database(entities = [EmailTemplateEntity::class], version = 1)
//abstract class EmailTemplateDatabase : RoomDatabase() {
//    abstract fun emailTemplateDao(): EmailTemplateDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: EmailTemplateDatabase? = null
//
//        fun getDatabase(context: Context): EmailTemplateDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    EmailTemplateDatabase::class.java,
//                    "email_templates_db"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}