package org.sonukg.domain.usecase

import org.sonukg.domain.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    val posts = repository.posts
    
    suspend operator fun invoke() {
        repository.fetchPosts()
    }
}
