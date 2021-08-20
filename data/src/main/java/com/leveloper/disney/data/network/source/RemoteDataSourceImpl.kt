package com.leveloper.disney.data.network.source

import com.leveloper.disney.data.network.safeApiCall
import com.leveloper.disney.data.network.service.DisneyService
import com.leveloper.disney.data.source.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: DisneyService
) : RemoteDataSource {

    override suspend fun getCharacters(page: Int) = safeApiCall(Dispatchers.IO) {
        service.getCharacters(page)
    }
}