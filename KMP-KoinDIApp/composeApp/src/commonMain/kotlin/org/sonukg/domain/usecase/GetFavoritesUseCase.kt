package org.sonukg.domain.usecase

import org.sonukg.domain.repository.PostRepository

class GetFavoritesUseCase(private val repository: PostRepository) {
    val favorites = repository.favorites
}
