package com.example.quickmail.utils

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns

fun Context.getFileName(uri: Uri): String? {
    val cursor = contentResolver.query(uri, null, null, null, null)
    return cursor?.use {
        val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        if (nameIndex != -1 && it.moveToFirst()) {
            it.getString(nameIndex)
        } else null
    }
}