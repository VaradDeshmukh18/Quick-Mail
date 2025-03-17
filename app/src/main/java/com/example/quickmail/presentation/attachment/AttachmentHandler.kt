package com.example.quickmail.presentation.attachment

import android.content.Context
import android.net.Uri
import com.example.quickmail.utils.FileUtils
import javax.inject.Inject


class AttachmentHandler @Inject constructor(
    private val context: Context
) {
    fun getFilePath(uri: Uri): String? {
        return FileUtils.getFilePathFromUri(context, uri)
    }
}