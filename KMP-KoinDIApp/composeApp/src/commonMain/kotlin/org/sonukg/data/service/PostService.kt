package org.sonukg.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.sonukg.data.dto.PostResponseDto

class PostService(private val client: HttpClient) {
    
    suspend fun getPosts(): PostResponseDto {
        return client.get("https://dummyjson.com/posts").body()
    }
}
