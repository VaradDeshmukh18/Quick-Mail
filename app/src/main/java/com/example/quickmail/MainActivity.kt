package com.example.quickmail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quickmail.presentation.email.EmailViewModel
import com.example.quickmail.presentation.navigation.Navigation
import com.example.quickmail.ui.theme.QuickMailTheme
import com.example.quickmail.utils.DeepLinkHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            QuickMailTheme {
                val navController = rememberNavController()
                Navigation(navController)

                // Handle deep links from intent
                intent?.let { DeepLinkHandler.handleDeepLink(it, navController) }
            }
        }



    }


}