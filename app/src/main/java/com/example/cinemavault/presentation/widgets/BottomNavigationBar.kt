package com.example.cinemavault.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinemavault.presentation.navigation.Route
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Route.Home, Route.Watch,Route.Details)
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    NavigationBar(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(horizontal = MediumPadding1,)
            .clip(shape = MaterialTheme.shapes.extraLarge),
        containerColor = MaterialTheme.colorScheme.onBackground
    ) {

        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    screen.vector?.let {
                        Icon(imageVector = it, contentDescription = screen.title)
                    }
                },
                label = {
                    Text(
                        text = screen.title ?: "",
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
