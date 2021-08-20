package com.leveloper.disney.domain.repository

import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {

    fun getCharactersAsFlow(): Flow<CharacterSnippet>

    fun getCharacter(characterId: Int): Result<Character>

}