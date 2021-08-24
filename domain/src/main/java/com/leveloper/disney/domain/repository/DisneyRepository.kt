package com.leveloper.disney.domain.repository

import androidx.paging.PagingData
import com.leveloper.core.Resource
import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {

    fun getCharactersAsFlow(): Flow<PagingData<CharacterSnippet>>

    suspend fun getCharacter(characterId: Int): Resource<Character>
}