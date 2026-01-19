package org.sonukg.presentation.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sonukg.domain.model.Post
import org.sonukg.domain.usecase.GetFavoritesUseCase
import org.sonukg.domain.usecase.ToggleFavoriteUseCase

data class FavState(
    val favoritePosts: List<Post> = emptyList()
)

class FavViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FavState())
    val state: StateFlow<FavState> = _state.asStateFlow()

    init {
        observeFavorites()
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase.favorites.collectLatest { favs ->
                _state.update { it.copy(favoritePosts = favs) }
            }
        }
    }

    fun toggleFavorite(post: Post) {
        viewModelScope.launch {
            toggleFavoriteUseCase(post.id)
        }
    }
}
