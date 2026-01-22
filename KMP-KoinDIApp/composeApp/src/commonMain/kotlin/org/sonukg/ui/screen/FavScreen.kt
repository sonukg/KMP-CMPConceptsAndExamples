package org.sonukg.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.sonukg.presentation.fav.FavViewModel
import org.sonukg.ui.component.PostItem

@Suppress("ktlint:standard:function-naming")
@OptIn(KoinExperimentalAPI::class)
@Composable
fun FavScreen(viewModel: FavViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.favoritePosts.isEmpty()) {
            Text(
                text = "No favorites yet",
                modifier = Modifier.align(Alignment.Center),
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.favoritePosts, key = { it.id }) { post ->
                    PostItem(
                        post = post,
                        onFavoriteClick = { viewModel.toggleFavorite(it) },
                    )
                }
            }
        }
    }
}
