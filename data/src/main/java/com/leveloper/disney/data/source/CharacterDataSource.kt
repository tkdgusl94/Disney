package com.leveloper.disney.data.source

import androidx.paging.PagingSource
import com.leveloper.core.Resource
import com.leveloper.disney.data.model.CharacterData
import com.leveloper.disney.data.model.CharacterSnippetData

interface CharacterDataSource {
    fun fetchCharacterPagingSource(): PagingSource<Int, CharacterSnippetData>

    suspend fun getCharacter(characterId: Int): Resource<CharacterData>
}