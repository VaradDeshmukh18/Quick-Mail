package com.example.quickmail.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns

object FileUtils {
    fun getFileName(context: Context, uri: Uri): String? {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        return cursor?.use {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1 && it.moveToFirst()) {
                it.getString(nameIndex)
            } else null
        }
    }

    fun getFilePathFromUri(context: Context, uri: Uri): String? {
        var fileName: String? = null
        val cursor: Cursor? = context.contentResolver.query(uri, null, null, null, null)

        cursor?.use {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1 && it.moveToFirst()) {
                fileName = it.getString(nameIndex)
            }
        }
        return fileName
    }
}