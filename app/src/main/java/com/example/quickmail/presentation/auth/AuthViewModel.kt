package com.example.quickmail.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmail.domain.usecase.auth.SignInWithGoogleUseCase
import com.example.quickmail.domain.usecase.auth.SignOutUseCase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {

    var user: FirebaseUser? = null
        private set

    fun signInWithGoogle(credential: AuthCredential, onSuccess: (FirebaseUser?) -> Unit) {
        viewModelScope.launch {
            user = signInWithGoogleUseCase(credential)
            onSuccess(user)
        }
    }

    fun signOut() {
        signOutUseCase()
        user = null
    }
}