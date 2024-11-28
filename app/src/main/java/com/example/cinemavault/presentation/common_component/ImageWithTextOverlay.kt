package com.example.cinemavault.presentation.common_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cinemavault.R
import com.example.cinemavault.presentation.utlis.Dimens.ImageHomeHeight
import com.example.cinemavault.presentation.utlis.Dimens.SmallPadding


@Composable
fun ImageWithTextOverlay() {
    Box(
        modifier = Modifier
            .padding(vertical = SmallPadding)
            .height(ImageHomeHeight)
            .clip(shape = MaterialTheme.shapes.extraLarge)
    ) {

        Image(
            painter = painterResource(R.drawable.home),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Text(
            text = "Find Your Next Favorite Movie",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(SmallPadding)
        )
    }
}
