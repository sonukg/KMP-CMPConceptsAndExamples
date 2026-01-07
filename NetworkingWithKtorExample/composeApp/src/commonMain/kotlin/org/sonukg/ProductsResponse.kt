package org.sonukg

import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    val products: List<Product>
)
