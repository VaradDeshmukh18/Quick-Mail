package com.example.quickmail.domain.usecase.email

import android.content.Context
import android.net.Uri
import com.example.quickmail.utils.FileUtils
import javax.inject.Inject

class AttachFileUseCase @Inject constructor(
    private val context: Context
) {
    operator fun invoke(fileUri: Uri): String? {
        return FileUtils.getFilePathFromUri(context, fileUri)
    }
}