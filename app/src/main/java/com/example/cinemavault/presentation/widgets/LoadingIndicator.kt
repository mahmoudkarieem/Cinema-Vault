package com.example.cinemavault.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0
import com.example.cinemavault.presentation.utlis.Dimens.SizeLoadingIndicator

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(SizeLoadingIndicator),
            color = MaterialTheme.colorScheme.secondary,
            strokeWidth = MediumPadding0
        )
    }
}
