package com.example.quickmail.presentation.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AttachmentPicker(onFileSelected: (Uri?) -> Unit) {
    var selectedFile by remember { mutableStateOf<Uri?>(null) }

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedFile = uri
        onFileSelected(uri)
    }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Button(onClick = { filePickerLauncher.launch("*/*") }) {
            Text("Attach File")
        }
        selectedFile?.let {
            Text("Selected File: ${it.lastPathSegment}", modifier = Modifier.padding(8.dp))
        }
    }
}