package com.leveloper.disney.domain.model

sealed class Resource<out T> {
    data class Success<out T>(val value: T): Resource<T>()
    data class Error(val message: String?): Resource<Nothing>()
}

inline fun <T> Resource<T>.onSuccess(onSuccess: (data: T) -> Unit): Resource<T> {
    if (this is Resource.Success) {
        onSuccess(this.value)
    }
    return this
}

inline fun <T> Resource<T>.onError(onError: (message: String?) -> Unit): Resource<T> {
    if (this is Resource.Error) {
        onError(this.message)
    }
    return this
}

inline fun <T, R> Resource<T>.map(transformed: (T) -> R): Resource<R> {
    return when (this) {
        is Resource.Success -> Resource.Success(transformed(this.value))
        is Resource.Error -> this
    }
}