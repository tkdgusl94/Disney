package com.leveloper.disney.remote.utils

import com.leveloper.core.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Resource<T> {
    return withContext(dispatcher) {
        try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Resource.Error("http exception")
//                    convertErrorBody(throwable)?.let { errorResponse ->
//                        Result.Error(errorResponse.error.message)
//                    } ?: Result.Error("unknown error")
                }
                is IOException -> {
                    Resource.Error("network error")
                }
                else -> {
                    Resource.Error(throwable.message)
                }
            }
        }
    }
}

//private fun convertErrorBody(throwable: HttpException): ErrorDto? {
//    return try {
//        throwable.response()?.errorBody()?.charStream()?.let {
//            Gson().fromJson(it, TypeToken.getParameterized(ErrorDto::class.java).type)
//        }
//    } catch (exception: Exception) {
//        null
//    }
//}