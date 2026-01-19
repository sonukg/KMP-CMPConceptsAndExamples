package org.sonukg.domain.usecase

import org.sonukg.domain.repository.PostRepository

class ToggleFavoriteUseCase(private val repository: PostRepository) {
    suspend operator fun invoke(postId: Int) {
        repository.toggleFavorite(postId)
    }
}
