package com.example.cinemavault.presentation.widgets

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemavault.presentation.viewModels.CategoryViewModel
import com.example.cinemavault.presentation.viewModels.MoviesViewModel

@Composable
fun GridListMovies(
    moviesViewModel: MoviesViewModel = hiltViewModel(),
    categoryViewModel: CategoryViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    if (categoryViewModel.categoryState.value.name.isNotEmpty()) {
        Log.d("MoviesList", "ListMovies: Success")

        moviesViewModel.getMovies(categoryId = categoryViewModel.categoryState.value.id.toString())
        MoviesList(navHostController = navHostController)
    } else {
        LoadingIndicator()
        Log.d("MoviesList", "ListMovies: Loading")


    }


}


