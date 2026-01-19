package org.sonukg.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponseDto(
    val posts: List<PostDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

@Serializable
data class PostDto(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: ReactionsDto,
    val views: Int,
    val userId: Int
)

@Serializable
data class ReactionsDto(
    val likes: Int,
    val dislikes: Int
)
