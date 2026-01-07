package org.sonukg

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel {
    private val repository = ProductRepository()

    var productsState: ApiResult<List<Product>> by mutableStateOf(ApiResult.Loading)
        private set

    fun getProducts() {
        CoroutineScope(Dispatchers.Main).launch {
            productsState = ApiResult.Loading
            productsState = repository.getProducts()
        }
    }
}
