package com.example.quickmail.data.remote

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class FirebaseAuthService {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun signInWithGoogle(credential: AuthCredential): FirebaseUser? {
        return try {
            val authResult = auth.signInWithCredential(credential).await()
            authResult.user
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun signOut() {
        auth.signOut()
    }

    fun getCurrentUser(): FirebaseUser? = auth.currentUser
}