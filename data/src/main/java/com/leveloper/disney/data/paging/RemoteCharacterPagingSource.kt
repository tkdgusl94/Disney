package com.leveloper.disney.data.paging

import com.leveloper.disney.data.network.dto.CharacterSimpleDto
import com.leveloper.disney.data.source.RemoteDataSource
import com.leveloper.disney.domain.model.Resource
import java.lang.Exception

class RemoteCharacterPagingSource(
    private val remoteDataSource: RemoteDataSource
) : BasePagingSource<CharacterSimpleDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterSimpleDto> {
        return try {
            val page = params.key ?: 1

            val result = remoteDataSource.getCharacters(page)

            return if (result is Resource.Success) {
                LoadResult.Page(
                    data = result.value.characters,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = page + 1
                )
            } else throw Exception("network error")
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}