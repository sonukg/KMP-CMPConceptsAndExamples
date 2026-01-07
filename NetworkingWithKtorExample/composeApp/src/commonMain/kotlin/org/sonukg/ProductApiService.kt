package org.sonukg

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductApiService(
    private val client: HttpClient = HttpClientProvider.client
) {

    suspend fun getProducts(): ApiResult<ProductsResponse> = safeApiCall {
        client.get("/products").body()
    }
}