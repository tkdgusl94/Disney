package com.leveloper.disney.data.repository

import com.leveloper.disney.data.source.RemoteDataSource
import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet
import com.leveloper.disney.domain.repository.DisneyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DisneyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : DisneyRepository {

    override fun getCharactersAsFlow(): Flow<CharacterSnippet> {
        TODO("Not yet implemented")
    }

    override fun getCharacter(characterId: Int): Result<Character> {
        TODO("Not yet implemented")
    }
}