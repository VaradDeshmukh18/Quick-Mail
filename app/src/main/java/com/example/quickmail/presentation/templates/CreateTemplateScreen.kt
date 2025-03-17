package com.example.quickmail.presentation.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CreateTemplateScreen(navController: NavController) {
    val viewModel: TemplateViewModel = viewModel()  // ✅ Move this inside the function

    var subject by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Template Subject") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = body,
            onValueChange = { body = it },
            label = { Text("Template Body") },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.saveTemplate(subject, body)
            navController.popBackStack()
        }) {
            Text("Save Template")
        }
    }
}
