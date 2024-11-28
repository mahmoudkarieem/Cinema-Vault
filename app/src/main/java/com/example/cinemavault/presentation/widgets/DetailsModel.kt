package com.example.cinemavault.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cinemavault.data.Constants.POSTER_BATH
import com.example.cinemavault.domain.Model.DetailsModel
import com.example.cinemavault.presentation.theme.CinemaVaultTheme
import com.example.cinemavault.presentation.utlis.Dimens.ExtraSmall
import com.example.cinemavault.presentation.utlis.Dimens.ImageHomeHeight
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding1
import com.example.cinemavault.presentation.utlis.Dimens.SmallPadding

@Composable
fun DetailsModelWidget(
    modifier: Modifier = Modifier,
    detailsModel: DetailsModel
) {

    Column(
        modifier
            .padding(MediumPadding1, vertical = MediumPadding0)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SmallPadding)
        ) {
            Text(
                text = "Details",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 25.sp

            )
            Text(
                modifier = Modifier.padding(start = MediumPadding0),
                text = "Movie",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 25.sp
            )
        }
        AsyncImage(
            modifier = Modifier
                .height(ImageHomeHeight)
                .fillMaxWidth()
                .padding(vertical = SmallPadding)
                .clip(shape = MaterialTheme.shapes.extraLarge),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            model = "$POSTER_BATH${detailsModel.posterPath}",
        )
        Text(
            modifier = Modifier.padding(vertical = SmallPadding),
            text = detailsModel.title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold

        )
        Row(
            modifier = Modifier.padding(
                vertical = MediumPadding0,
            ), horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Overview:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),

                text = detailsModel.overview,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Row(
            modifier = Modifier.align(alignment = Alignment.Start)
        ) {
            Text(
                modifier = Modifier,
                text = "originalLanguage :",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),
                text = detailsModel.originalLanguage,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Row(modifier = Modifier.padding(vertical = MediumPadding0)) {
            Text(

                text = "The Budget:",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,


                )
            Text(
                modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),
                text = detailsModel.budget.toString(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }


        Row(modifier = Modifier.padding(vertical = MediumPadding0)) {
            Text(

                text = "Vote Average:",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,


                )
            Text(
                modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),
                text = detailsModel.voteAverage.toString(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Row(modifier = Modifier.padding(vertical = MediumPadding0)) {
            Text(
                text = "Genres:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            detailsModel.genres.forEach { genre ->
                Text(
                    modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),
                    text = genre.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

        }
        Row(modifier = Modifier.padding(vertical = MediumPadding0)) {
            Text(
                text = "productionCompanies:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            detailsModel.productionCompanies.forEach { genre ->
                Text(
                    modifier = Modifier.padding(start = MediumPadding0, top = ExtraSmall),
                    text = genre.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                    , maxLines = 2
                )
            }
        }
    }

}

@Preview
@Composable
private fun PreviewDetailsModel() {
    CinemaVaultTheme {

    }

}