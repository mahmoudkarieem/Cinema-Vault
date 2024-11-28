package com.example.cinemavault.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinemavault.presentation.views.DetailsView
import com.example.cinemavault.presentation.views.HomeView
import com.example.cinemavault.presentation.views.SplashView
import com.example.cinemavault.presentation.views.WatchingView

@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Route.Splash.route) {

        composable(Route.Splash.route) {
            SplashView(navController = navController)
        }
        composable(Route.Home.route) {
            HomeView(navHostController = navController)
        }
        composable(Route.Watch.route) {
            WatchingView(navHostController = navController)
        }
        composable(
            route = Route.Details.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            if (movieId != null) {
                DetailsView(
                    navHostController = navController,
                    movieId = movieId
                )
            } else {
              
                Text(text = "Invalid movie ID")
            }
        }

    }

}