package com.leveloper.disney.data.paging

import androidx.paging.*
import kotlinx.coroutines.flow.Flow

abstract class BasePagingSource<Value : Any> : PagingSource<Int, Value>() {

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return 0
    }

    fun asFlow(pageSize: Int = DEFAULT_PAGING_SIZE): Flow<PagingData<Value>> {
        return Pager(config = PagingConfig(pageSize)) {
            this
        }.flow
    }

    companion object {
        private const val DEFAULT_PAGING_SIZE = 10
    }
}