package com.example.cinemavault.presentation.common_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cinemavault.data.Constants.POSTER_BATH
import com.example.cinemavault.domain.Model.MoviesItemModel
import com.example.cinemavault.presentation.navigation.Route
import com.example.cinemavault.presentation.utlis.Dimens.HeightGridList
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0

@Composable
fun CustomCardMovies(
    moviesModel: MoviesItemModel,
    navHostController: NavHostController
) {
    Column(modifier = Modifier
        .padding(MediumPadding0)
        .clickable {
            navHostController.navigate("${Route.Details.route}/${moviesModel.id}")
        }) {
        AsyncImage(
            modifier = Modifier
                .height(HeightGridList)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium),
            model = "$POSTER_BATH${moviesModel.posterPath}",
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = moviesModel.title,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 18.sp,
            maxLines = 1,
            modifier = Modifier.padding(vertical = MediumPadding0)
        )
    }

}