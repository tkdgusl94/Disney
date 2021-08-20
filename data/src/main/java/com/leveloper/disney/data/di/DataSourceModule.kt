package com.leveloper.disney.data.di

import com.leveloper.disney.data.network.source.RemoteDataSourceImpl
import com.leveloper.disney.data.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Binds
    @Singleton
    fun bindRemoteDataSource(source: RemoteDataSourceImpl): RemoteDataSource
}