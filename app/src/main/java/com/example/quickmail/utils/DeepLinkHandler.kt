package com.example.quickmail.utils

import android.content.Intent
import androidx.navigation.NavController
import com.example.quickmail.presentation.navigation.Screen

object DeepLinkHandler {
    fun handleDeepLink(intent: Intent?, navController: NavController) {
        intent?.data?.let { uri ->
            if (uri.scheme == "mailto") {
                val recipient = uri.schemeSpecificPart.substringBefore("?")
                val subject = uri.getQueryParameter("subject") ?: ""
                val body = uri.getQueryParameter("body") ?: ""

                navController.navigate("${Screen.EmailCompose.route}?recipient=$recipient&subject=$subject&body=$body")
            }
        }
    }
}