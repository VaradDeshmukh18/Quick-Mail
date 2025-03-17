package com.example.quickmail.presentation.navigation

sealed class Screen(val route: String) {
    object SignIn : Screen("sign_in")
    object EmailCompose : Screen("email_compose")
    object EmailSent : Screen("email_sent")
    object Templates : Screen("templates")
    object CreateTemplate : Screen("create_template")
}