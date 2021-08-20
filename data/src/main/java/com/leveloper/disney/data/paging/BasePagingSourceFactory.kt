package com.leveloper.disney.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow

abstract class BasePagingSourceFactory<Value : Any> {

    protected abstract fun createDataSource(): PagingSource<Int, Value>

    fun getPagingFlow(pageSize: Int = DEFAULT_PAGING_SIZE): Flow<PagingData<Value>> {
        return Pager(config = PagingConfig(pageSize)) {
            createDataSource()
        }.flow
    }

    companion object {
        private const val DEFAULT_PAGING_SIZE = 1
    }
}