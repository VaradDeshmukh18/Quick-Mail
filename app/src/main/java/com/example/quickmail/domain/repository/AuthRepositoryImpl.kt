package com.example.quickmail.domain.repository

import com.example.quickmail.data.remote.FirebaseAuthService
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: FirebaseAuthService
) : AuthRepository {

    override suspend fun signInWithGoogle(credential: AuthCredential): FirebaseUser? {
        return authService.signInWithGoogle(credential)
    }

    override fun signOut() {
        authService.signOut()
    }

    override fun getCurrentUser(): FirebaseUser? {
        return authService.getCurrentUser()
    }
}