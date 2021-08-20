package com.leveloper.disney.data.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leveloper.disney.domain.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Result<T> {
    return withContext(dispatcher) {
        try {
            Result.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Result.Error("http exception")
//                    convertErrorBody(throwable)?.let { errorResponse ->
//                        Result.Error(errorResponse.error.message)
//                    } ?: Result.Error("unknown error")
                }
                is IOException -> {
                    Result.Error("network error")
                }
                else -> {
                    Result.Error(throwable.message)
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