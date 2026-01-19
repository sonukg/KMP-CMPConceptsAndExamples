package org.sonukg.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sonukg.domain.model.Post

interface PostRepository {
    val posts: Flow<List<Post>>
    val favorites: Flow<List<Post>>
    
    suspend fun fetchPosts()
    suspend fun toggleFavorite(postId: Int)
}
