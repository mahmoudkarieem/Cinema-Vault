package com.example.cinemavault.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemavault.presentation.utlis.Dimens.MediumPadding0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
        .padding(vertical = MediumPadding0)
        .clip(shape = MaterialTheme.shapes.extraLarge),
    placeholderText: String = "Search...",
    onSearch: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = modifier
            .fillMaxWidth()

            .background(color = MaterialTheme.colorScheme.onBackground)
            .padding(8.dp)
            .clip(shape = MaterialTheme.shapes.extraLarge)

    ) {
        IconButton(
            onClick = { onSearch(searchQuery.text) },
            modifier = Modifier.align(Alignment.CenterVertically),
            colors = IconButtonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.secondary,
                disabledContentColor = MaterialTheme.colorScheme.onBackground,
                disabledContainerColor = MaterialTheme.colorScheme.onPrimaryContainer
            )


        ) {
            Icon(
                Icons.Default.Search, contentDescription = "Search",

                )
        }
        TextField(

            value = searchQuery,
            onValueChange = {
                searchQuery = it
                onSearch(it.text)
            },
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            },
            modifier = Modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.background),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(

                containerColor = MaterialTheme.colorScheme.onBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.secondary,
                focusedTextColor = MaterialTheme.colorScheme.secondary// Cursor color to match
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    SearchBar(
        onSearch = { query -> println("Search query: $query") }
    )
}
