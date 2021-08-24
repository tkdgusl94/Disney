package com.leveloper.disney.remote.datasource

import androidx.paging.PagingSource
import com.leveloper.core.Resource
import com.leveloper.disney.data.model.CharacterData
import com.leveloper.disney.data.model.CharacterSnippetData
import com.leveloper.disney.data.source.CharacterDataSource
import com.leveloper.disney.remote.mapper.toData
import com.leveloper.disney.remote.paging.CharacterPagingSource
import com.leveloper.disney.remote.service.DisneyService
import com.leveloper.disney.remote.utils.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterDataSourceImpl @Inject constructor(
    private val disneyService: DisneyService
) : CharacterDataSource {

    override fun fetchCharacterPagingSource(): PagingSource<Int, CharacterSnippetData> {
        return CharacterPagingSource(disneyService)
    }

    override suspend fun getCharacter(characterId: Int): Resource<CharacterData> = safeApiCall(Dispatchers.IO) {
        disneyService.getCharacter(characterId).toData()
    }
}