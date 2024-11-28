package com.example.cinemavault.presentation.widgets

import android.util.Log
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cinemavault.domain.Model.CategoriesItemModel
import com.example.cinemavault.presentation.common_component.CustomTextCategories
import com.example.cinemavault.presentation.viewModels.CategoryViewModel

@Composable
fun CategoriesList(
    categoryViewModel: CategoryViewModel = hiltViewModel()
) {
    when {
        categoryViewModel.state.value.loading -> {
            Log.d("CategoriesList", "Items: in Loading")

        }
        categoryViewModel.state.value.success.isNotEmpty() -> {
            LazyRow {
                val itemsList = categoryViewModel.state.value.success
                Log.d("CategoriesList", "Items: $itemsList")
                items(itemsList) { title ->
                    CustomTextCategories(
                        modifier = Modifier,
                        categoryTitle = title,
                        selected = categoryViewModel.categoryState.value == title,
                        onSelected = {
                            if (categoryViewModel.categoryState.value == title)
                                categoryViewModel.getCategory(CategoriesItemModel())
                            else
                                categoryViewModel.getCategory(title)
                        }
                    )
                }
            }
        }

        categoryViewModel.state.value.error.isNotEmpty() -> {
            Log.d("CategoriesList", "Items: has been error")
            Text(text = "Error loading categories: ${categoryViewModel.state.value.error}")

        }
    }
}