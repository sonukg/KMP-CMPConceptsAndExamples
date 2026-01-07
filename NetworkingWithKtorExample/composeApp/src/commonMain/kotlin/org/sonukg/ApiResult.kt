package org.sonukg

sealed class ApiResult<out T> {
    object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T): ApiResult<T>()
    data class Error(val message: String, val code: Int? = null): ApiResult<Nothing>()
}