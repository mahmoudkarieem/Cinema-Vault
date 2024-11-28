package com.example.cinemavault.presentation.common_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cinemavault.domain.Model.CategoriesItemModel
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0

@Composable
fun CustomTextCategories(
    modifier: Modifier = Modifier,
    categoryTitle: CategoriesItemModel,
    selected: Boolean = false,
    onSelected: ((movies: CategoriesItemModel) -> Unit),

    ) {
    Surface(
        modifier = Modifier
            .clickable {
                onSelected(categoryTitle)
            }
            .padding(MediumPadding0),
        shape = MaterialTheme.shapes.medium,
        color = if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onBackground
    ) {
        Text(
            text = categoryTitle.name,
            modifier = Modifier
                .padding(end = MediumPadding0)
                .padding(vertical = MediumPadding0),
            style = MaterialTheme.typography.displaySmall,
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,

            fontSize = 21.sp
        )
    }
}