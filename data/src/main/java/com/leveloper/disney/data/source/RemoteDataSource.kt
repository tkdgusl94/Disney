package com.leveloper.disney.data.source

import com.leveloper.disney.data.network.dto.CharactersResponse
import com.leveloper.disney.domain.model.Result

interface RemoteDataSource {

    suspend fun getCharacters(page: Int): Result<CharactersResponse>
}