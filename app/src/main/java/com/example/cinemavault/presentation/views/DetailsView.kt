package com.example.cinemavault.presentation.views

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemavault.presentation.utlis.showToast
import com.example.cinemavault.presentation.viewModels.DetailsViewModel
import com.example.cinemavault.presentation.widgets.BottomNavigationBar
import com.example.cinemavault.presentation.widgets.DetailsModelWidget
import com.example.cinemavault.presentation.widgets.LoadingIndicator

@Composable
fun DetailsView(
    navHostController: NavHostController,
    movieId: Int,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(movieId) {
        viewModel.getDetailsScreen(movieId)
        showToast(context = context, "Details View", duration = Toast.LENGTH_SHORT)
    }
    val scrollState = rememberScrollState()
    val state = viewModel.state.value

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navHostController) }
    ) { innerPadding ->
        if (state.loading) {

            Log.d("DetailsView", "DetailsView:Loading  ")
            LoadingIndicator()

        } else if (state.error.isNotEmpty()) {
            Log.d("DetailsView", "DetailsView:Error  ")
            Text(text = state.error, modifier = Modifier.padding(innerPadding))
        } else {
            Log.d("DetailsView", "DetailsView:Success  ")

            state.success?.let { details ->
                DetailsModelWidget(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(scrollState),
                    detailsModel = details
                )
            }
        }
    }
}
