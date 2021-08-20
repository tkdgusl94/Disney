package com.leveloper.disney.domain.model

sealed class Result<out T> {
    data class Success<out T>(val value: T): Result<T>()
    data class Error(val message: String?): Result<Nothing>()
}

inline fun <T> Result<T>.onSuccess(onSuccess: (data: T) -> Unit): Result<T> {
    if (this is Result.Success) {
        onSuccess(this.value)
    }
    return this
}

inline fun <T> Result<T>.onError(onError: (message: String?) -> Unit): Result<T> {
    if (this is Result.Error) {
        onError(this.message)
    }
    return this
}