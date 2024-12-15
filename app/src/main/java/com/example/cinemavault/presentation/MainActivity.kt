package com.example.cinemavault.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cinemavault.presentation.navigation.NavigationHost
import com.example.cinemavault.presentation.theme.CinemaVaultTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CinemaVaultTheme {

                NavigationHost()

            }
        }
    }
}

