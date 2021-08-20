package com.leveloper.disney.data.di

import com.leveloper.disney.data.repository.DisneyRepositoryImpl
import com.leveloper.disney.domain.repository.DisneyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBannerRepository(repository: DisneyRepositoryImpl): DisneyRepository
}