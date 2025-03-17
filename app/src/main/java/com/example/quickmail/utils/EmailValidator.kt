package com.example.quickmail.utils

import android.util.Patterns

object EmailValidator {
    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}