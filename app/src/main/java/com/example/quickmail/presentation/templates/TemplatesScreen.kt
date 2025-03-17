package com.example.quickmail.presentation.templates

import androidx.compose.foundation.layout.Arrangement
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickmail.presentation.navigation.Screen

@Composable
fun TemplatesScreen(navController: NavController) {
    val viewModel: TemplateViewModel = viewModel()
    val templates by viewModel.templates.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { viewModel.loadTemplates() }) {
                Text("Load Templates")
            }
            Button(onClick = { navController.navigate(Screen.CreateTemplate.route) }) {
                Text("Create New")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        if (templates.isEmpty()) {
            Text(
                text = "No templates found. Create a new template!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            LazyColumn {
                items(templates) { template ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text("Subject: ${template.subject}", style = MaterialTheme.typography.bodyLarge)
                            Text("Body: ${template.body}", style = MaterialTheme.typography.bodySmall)
                            Spacer(modifier = Modifier.height(8.dp))
                            Row {
                                Button(onClick = { viewModel.deleteTemplate(template) }) {
                                    Text("Delete")
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(onClick = { navController.navigate("email_compose?body=${template.body}") }) {
                                    Text("Use")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}