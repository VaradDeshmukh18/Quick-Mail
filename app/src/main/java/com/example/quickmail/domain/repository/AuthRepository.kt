package com.example.quickmail.domain.repository

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signInWithGoogle(credential: AuthCredential): FirebaseUser?
    fun signOut()
    fun getCurrentUser(): FirebaseUser?
}