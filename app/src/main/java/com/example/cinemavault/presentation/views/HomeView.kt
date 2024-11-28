package com.example.cinemavault.presentation.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cinemavault.presentation.common_component.ImageWithTextOverlay
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1
import com.example.cinemavault.presentation.utlis.Dimens.SmallPadding
import com.example.cinemavault.presentation.utlis.showToast
import com.example.cinemavault.presentation.widgets.BottomNavigationBar
import com.example.cinemavault.presentation.widgets.TrendingListView
import androidx.compose.runtime.remember

@Composable
fun HomeView( navHostController: NavHostController) {
    val context = LocalContext.current
    val toastShown = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (toastShown.value) {
            showToast(context = context, "Welcome to Home View!", duration = Toast.LENGTH_SHORT)
            toastShown.value = true

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
                .padding(horizontal = MediumPadding1, vertical = SmallPadding)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(top = SmallPadding)
            ) {
                Text(
                    text = "Stream",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 25.sp

                )
                Text(
                    modifier = Modifier.padding(start = MediumPadding0),
                    text = "Everywhere",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp
                )
            }

            ImageWithTextOverlay()
            Text(
                text = "Trending",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 25.sp

            )
            TrendingListView(navHostController = navHostController)
        }


    }


}