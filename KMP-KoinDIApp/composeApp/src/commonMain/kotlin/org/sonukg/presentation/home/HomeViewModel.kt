package org.sonukg.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sonukg.domain.model.Post
import org.sonukg.domain.usecase.GetPostsUseCase
import org.sonukg.domain.usecase.ToggleFavoriteUseCase

data class HomeState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class HomeViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadPosts()
        observePosts()
    }

    private fun observePosts() {
        viewModelScope.launch {
            getPostsUseCase.posts.collectLatest { posts ->
                _state.update { it.copy(posts = posts) }
            }
        }
    }

    fun loadPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                getPostsUseCase()
                _state.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message ?: "Unknown error") }
            }
        }
    }

    fun toggleFavorite(post: Post) {
        viewModelScope.launch {
            toggleFavoriteUseCase(post.id)
        }
    }
}
