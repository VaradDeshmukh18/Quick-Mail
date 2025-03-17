package com.example.quickmail.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.example.quickmail.presentation.auth.GoogleSignInScreen
import com.example.quickmail.presentation.email.EmailComposeScreen
import com.example.quickmail.presentation.email.EmailSentScreen
import com.example.quickmail.presentation.templates.TemplatesScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickmail.presentation.templates.CreateTemplateScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.SignIn.route) { GoogleSignInScreen() }
        composable(Screen.EmailCompose.route) { EmailComposeScreen() }
        composable(Screen.EmailSent.route) { EmailSentScreen(navController) }
        composable(Screen.Templates.route) { TemplatesScreen(navController) }
        composable(Screen.CreateTemplate.route) { CreateTemplateScreen(navController) }
    }
}