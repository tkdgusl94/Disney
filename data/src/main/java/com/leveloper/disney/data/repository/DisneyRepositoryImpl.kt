package com.leveloper.disney.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.leveloper.disney.data.paging.RemoteCharacterPagingSource
import com.leveloper.disney.data.source.RemoteDataSource
import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet
import com.leveloper.disney.domain.model.Resource
import com.leveloper.disney.domain.model.map
import com.leveloper.disney.domain.repository.DisneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DisneyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : DisneyRepository {

    override fun getCharactersAsFlow(): Flow<PagingData<CharacterSnippet>> {
        return RemoteCharacterPagingSource(remoteDataSource).asFlow().map { pagingData ->
            pagingData.map {
                it.toModel()
            }
        }
    }

    override suspend fun getCharacter(characterId: Int): Resource<Character> {
        return remoteDataSource.getCharacter(characterId).map { it.toModel() }
    }
}