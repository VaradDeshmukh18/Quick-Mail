package com.example.quickmail.presentation.auth

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun GoogleSignInScreen(authViewModel: AuthViewModel = viewModel()) {
    val context = LocalContext.current
    val oneTapClient = remember { Identity.getSignInClient(context) }
    val signInRequest = remember {
        BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("YOUR_WEB_CLIENT_ID")  // Replace with your Web Client ID
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .build()
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
            val idToken = credential.googleIdToken
            if (idToken != null) {
                val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                authViewModel.signInWithGoogle(firebaseCredential) {
                    Toast.makeText(context, "Signed in as: ${it?.displayName}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener { result ->
                    launcher.launch(result.pendingIntent.intentSender)
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Sign-in failed: ${it.localizedMessage}", Toast.LENGTH_LONG).show()
                }
        }) {
            Text("Sign in with Google")
        }
    }
}