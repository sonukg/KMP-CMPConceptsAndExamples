package org.sonukg.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sonukg.data.dto.PostDto
import org.sonukg.data.service.PostService
import org.sonukg.domain.model.Post
import org.sonukg.domain.model.Reactions
import org.sonukg.domain.repository.PostRepository

class PostRepositoryImpl(
    private val api: PostService
) : PostRepository {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    override val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _favorites = MutableStateFlow<List<Post>>(emptyList())
    override val favorites: StateFlow<List<Post>> = _favorites.asStateFlow()

    override suspend fun fetchPosts() {
        try {
            val response = api.getPosts()
            val domainPosts = response.posts.map { it.toDomain() }
            
            // Sync with current favorites
            val currentFavIds = _favorites.value.map { it.id }.toSet()
            val syncedPosts = domainPosts.map { post ->
                if (post.id in currentFavIds) post.copy(isFavorite = true) else post
            }
            
            _posts.update { syncedPosts }
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle error appropriately, potentially expose error state
        }
    }

    override suspend fun toggleFavorite(postId: Int) {
        val currentPosts = _posts.value
        val post = currentPosts.find { it.id == postId } ?: return
        
        val newFavoriteStatus = !post.isFavorite
        
        // Update posts list
        _posts.update { posts ->
            posts.map { if (it.id == postId) it.copy(isFavorite = newFavoriteStatus) else it }
        }

        // Update favorites list
        _favorites.update { 
            if (newFavoriteStatus) {
                it + post.copy(isFavorite = true)
            } else {
                it.filter { fav -> fav.id != postId }
            }
        }
    }

    private fun PostDto.toDomain(): Post {
        return Post(
            id = id,
            title = title,
            body = body,
            tags = tags,
            reactions = Reactions(reactions.likes, reactions.dislikes),
            views = views,
            userId = userId,
            isFavorite = false
        )
    }
}
