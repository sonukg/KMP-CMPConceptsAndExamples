package org.sonukg

class ProductRepository {
    private val apiService = ProductApiService()

    suspend fun getProducts(): ApiResult<List<Product>> {
        return when (val result = apiService.getProducts()) {
            is ApiResult.Success -> ApiResult.Success(result.data.products)
            is ApiResult.Error -> ApiResult.Error(result.message)
            is ApiResult.Loading -> ApiResult.Loading
        }
    }
}
