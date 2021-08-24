package com.leveloper.disney.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.leveloper.core.Resource
import com.leveloper.core.map
import com.leveloper.disney.data.mapper.toModel
import com.leveloper.disney.data.source.CharacterDataSource
import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet
import com.leveloper.disney.domain.repository.DisneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DisneyRepositoryImpl @Inject constructor(
    private val remoteCharacterDataSource: CharacterDataSource
) : DisneyRepository {

    override fun getCharactersAsFlow(): Flow<PagingData<CharacterSnippet>> {
        return Pager(PagingConfig(10)) {
            remoteCharacterDataSource.fetchCharacterPagingSource()
        }.flow
            .map { pagingData ->
                pagingData.map {
                    it.toModel()
                }
            }
    }

    override suspend fun getCharacter(characterId: Int): Resource<Character> {
        return remoteCharacterDataSource
            .getCharacter(characterId)
            .map { it.toModel() }
    }
}