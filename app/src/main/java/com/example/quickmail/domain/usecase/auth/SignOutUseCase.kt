package com.example.quickmail.domain.usecase.auth

import com.example.quickmail.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() {
        repository.signOut()
    }
}