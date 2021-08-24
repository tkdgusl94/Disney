package com.leveloper.disney.di.remote

import com.leveloper.disney.data.source.CharacterDataSource
import com.leveloper.disney.remote.datasource.CharacterDataSourceImpl
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
    fun bindCharacterDataSource(dataSource: CharacterDataSourceImpl): CharacterDataSource
}