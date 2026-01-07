package org.sonukg

import kotlinx.serialization.Serializable

@Serializable
data class Product(val id: Int, val title: String, val price: Double,)
