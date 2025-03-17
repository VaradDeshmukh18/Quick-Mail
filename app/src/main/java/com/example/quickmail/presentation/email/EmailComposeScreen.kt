package com.example.quickmail.presentation.email

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickmail.presentation.components.AttachmentPicker
import com.example.quickmail.presentation.components.EmailComposer

@Composable
fun EmailComposeScreen(emailViewModel: EmailViewModel = viewModel()) {
    val context = LocalContext.current
    var recipient by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var attachmentPath by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        EmailComposer(
            recipient = recipient,
            subject = subject,
            body = body,
            onRecipientChange = { recipient = it },
            onSubjectChange = { subject = it },
            onBodyChange = { body = it },
            onSendClick = {
                emailViewModel.sendEmail(
                    senderEmail = "your-email@gmail.com",
                    senderPassword = "your-password",
                    recipientEmail = recipient,
                    subject = subject,
                    body = body,
                    attachmentPath = attachmentPath
                ) { success ->
                    Toast.makeText(context, if (success) "Email Sent" else "Failed", Toast.LENGTH_LONG).show()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        AttachmentPicker { uri -> attachmentPath = uri?.toString() }
    }
}
