package com.example.quickmail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quickmail.domain.model.EmailTemplate
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items



@Composable
fun TemplateSelector(
    templates: List<EmailTemplate>,
    onTemplateSelected: (EmailTemplate) -> Unit
) {
    if (templates.isEmpty()) {
        Text("No templates available. Create one!", modifier = Modifier.padding(8.dp))
    } else {
        LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            items(templates) { template ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Subject: ${template.subject}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Body: ${template.body}", style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { onTemplateSelected(template) }) {
                            Text("Use Template")
                        }
                    }
                }
            }
        }
    }
}