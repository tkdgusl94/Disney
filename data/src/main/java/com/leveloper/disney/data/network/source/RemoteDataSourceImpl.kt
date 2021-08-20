package com.leveloper.disney.data.network.source

import com.leveloper.disney.data.network.service.DisneyService
import com.leveloper.disney.data.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: DisneyService
) : RemoteDataSource {

}