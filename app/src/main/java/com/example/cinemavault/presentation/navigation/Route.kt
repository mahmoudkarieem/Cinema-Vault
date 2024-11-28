package com.example.cinemavault.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(val route: String, val vector: ImageVector? = null, val title: String? = null) {
    object Splash : Route(route = "splash")
    object Home : Route(route = "HomeView", vector = Icons.Filled.Home, title = "Home")
    object Watch : Route(route = "WatchingView", vector = Icons.Filled.Search, title = "Watching")
    object Details : Route(route = "DetailsView", vector = Icons.Filled.List, title = "Details")
}