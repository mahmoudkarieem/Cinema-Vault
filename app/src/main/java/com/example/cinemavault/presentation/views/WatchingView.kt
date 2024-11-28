package com.example.cinemavault.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1
import com.example.cinemavault.presentation.utlis.showToast
import com.example.cinemavault.presentation.widgets.BottomNavigationBar
import com.example.cinemavault.presentation.widgets.CategoriesList
import com.example.cinemavault.presentation.widgets.GridListMovies
import com.example.cinemavault.presentation.widgets.SearchBar

@Composable
fun WatchingView(

    navHostController: NavHostController,
) {
    val context = LocalContext.current
    val state = remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        if (state.value) {
            showToast(context = context, "Enter Categories To Show Movies List")
            state.value = true
        }
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navHostController) }

    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = MediumPadding1, vertical = MediumPadding0)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MediumPadding0)

            ) {
                Text(
                    text = "Discover Action, Comedy, Animation & More",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp

                )
            }

            SearchBar(placeholderText = "Search ", onSearch = {})

            CategoriesList()

            GridListMovies(navHostController = navHostController)
        }

    }

}