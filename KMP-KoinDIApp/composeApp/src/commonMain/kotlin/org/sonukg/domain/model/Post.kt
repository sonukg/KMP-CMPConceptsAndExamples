package org.sonukg.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: Reactions,
    val views: Int,
    val userId: Int,
    val isFavorite: Boolean = false
)

@Serializable
data class Reactions(
    val likes: Int,
    val dislikes: Int
)
