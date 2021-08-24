package com.leveloper.disney.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leveloper.core.Resource
import com.leveloper.disney.data.model.CharacterSnippetData
import com.leveloper.disney.remote.mapper.toData
import com.leveloper.disney.remote.service.DisneyService
import com.leveloper.disney.remote.utils.safeApiCall
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(
    private val disneyService: DisneyService
) : PagingSource<Int, CharacterSnippetData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterSnippetData> {
        return try {
            val page = params.key ?: 1

            val result = safeApiCall(Dispatchers.IO) {
                disneyService.getCharacters(page)
            }

            return if (result is Resource.Success) {
                LoadResult.Page(
                    data = result.value.characters.map { it.toData() },
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = page + 1
                )
            } else throw Exception("network error")
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterSnippetData>): Int {
        return 0
    }
}