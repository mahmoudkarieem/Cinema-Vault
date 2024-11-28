package com.example.cinemavault.presentation.common_component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemavault.presentation.theme.CinemaVaultTheme

@Composable
fun CircularIndicator(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp), // Size of the indicator
            strokeWidth = 4.dp // Thickness of the indicator
        )
    }


}

@Preview
@Composable
private fun PreviewCircularIndicator() {
    CinemaVaultTheme {
        CircularIndicator()
    }

}