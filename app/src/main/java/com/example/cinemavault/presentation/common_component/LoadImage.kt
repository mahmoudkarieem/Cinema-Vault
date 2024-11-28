package com.example.cinemavault.presentation.common_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cinemavault.presentation.utlis.Dimens.ListHomeImageHeight
import com.example.cinemavault.R
import com.example.cinemavault.data.Constants.POSTER_BATH
import com.example.cinemavault.domain.Model.MovieTrendingItemModel
import com.example.cinemavault.domain.Model.MoviesItemModel
import com.example.cinemavault.domain.Model.TrendingMoviesModel
import com.example.cinemavault.presentation.navigation.Route
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0
import com.example.cinemavault.presentation.utlis.Dimens.SmallPadding


@Composable
fun LoadImageForListTrending(
    moviesItemModel: MovieTrendingItemModel,
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .padding(vertical = MediumPadding0)
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .clickable {
                navHostController.navigate(Route.Details.route + "/${moviesItemModel.id}")
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .height(ListHomeImageHeight)
                .padding(horizontal = MediumPadding0)
                .clip(shape = MaterialTheme.shapes.extraLarge),
            model = "$POSTER_BATH${moviesItemModel.posterPath}",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.onbording2)
        )
        Text(
            text = moviesItemModel.title,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(SmallPadding)
        )
    }

}