package com.example.quickmail.domain.usecase.auth

import com.example.quickmail.domain.repository.AuthRepository
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(credential: AuthCredential): FirebaseUser? {
        return repository.signInWithGoogle(credential)
    }
}