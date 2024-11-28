package com.example.cinemavault.presentation.widgets

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cinemavault.presentation.common_component.CircularIndicator
import com.example.cinemavault.presentation.common_component.CustomCardMovies
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1
import com.example.cinemavault.presentation.viewModels.MoviesViewModel
import com.example.cinemavault.presentation.views.ErrorViewState

@Composable
fun MoviesList(
    viewModel: MoviesViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val stateMovies = viewModel.stateMovies.value
    val movies = stateMovies.success!!.flow.collectAsLazyPagingItems()

    if (stateMovies.error.isNotEmpty()) {
        Log.d("MoviesList", "ListMovies:${stateMovies.error.toString()}")

    } else if (stateMovies.loading) {
        Log.d("MoviesList", "ListMovies: Loading")
        CircularIndicator()
    } else {
        LazyVerticalGrid(
            modifier = Modifier.padding(vertical = MediumPadding1),
            columns = GridCells.Fixed(2),
            content = {
                items(movies.itemCount) { movie ->
                    CustomCardMovies(
                        moviesModel = movies[movie]!!,
                        navHostController = navHostController
                    )
                }
            }
        )


    }
}