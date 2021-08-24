package com.leveloper.disney.data.source

import com.leveloper.disney.data.network.dto.CharacterDto
import com.leveloper.disney.data.network.dto.CharactersResponse
import com.leveloper.disney.domain.model.Resource

interface RemoteDataSource {

    suspend fun getCharacters(page: Int): Resource<CharactersResponse>

    suspend fun getCharacter(characterId: Int): Resource<CharacterDto>
}