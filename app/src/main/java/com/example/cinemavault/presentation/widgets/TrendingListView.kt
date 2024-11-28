package com.example.cinemavault.presentation.widgets

import android.util.Log
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemavault.presentation.common_component.LoadImageForListTrending
import com.example.cinemavault.presentation.viewModels.TrendingViewModel

@Composable
fun TrendingListView(
    modifier: Modifier = Modifier,
    trendingViewModel: TrendingViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    if (trendingViewModel.state.value.success.isNotEmpty()) {
        Log.d("TrendingListView", "TrendingListView: Success ")
        LazyRow(modifier) {
            val itemsList = trendingViewModel.state.value.success
            items(itemsList) { imagesUrl ->
                LoadImageForListTrending(
                    moviesItemModel = imagesUrl,
                    navHostController = navHostController
                )
            }
        }
    } else if (trendingViewModel.state.value.isLoading) {
        Log.d("TrendingListView", "TrendingListView: Loading ")
        LoadingIndicator()

    } else {
        Log.d("TrendingListView", "TrendingListView: Failure ")


    }
}