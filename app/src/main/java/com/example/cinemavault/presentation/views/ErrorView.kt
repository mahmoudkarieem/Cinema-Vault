package com.example.cinemavault.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.cinemavault.R
import com.example.cinemavault.presentation.utlis.Dimens.ImageHomeHeight
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding3
import com.example.cinemavault.presentation.utlis.Dimens.SmallPadding

@Composable
fun ErrorViewState(modifier: Modifier = Modifier.fillMaxSize()) {

    Column(modifier = Modifier.padding(vertical = MediumPadding3, horizontal = MediumPadding1)) {

        Image(
            painter = painterResource(R.drawable.error_photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(ImageHomeHeight)
        )
        Text(
            modifier = Modifier.padding(top =SmallPadding ),
            text = "Check Internet Connection",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}