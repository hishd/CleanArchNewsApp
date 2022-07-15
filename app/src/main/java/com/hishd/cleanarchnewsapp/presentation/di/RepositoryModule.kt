package com.hishd.cleanarchnewsapp.presentation.di

import com.hishd.cleanarchnewsapp.data.repository.NewsRepositoryImpl
import com.hishd.cleanarchnewsapp.data.repository.datasource.NewsRemoteDataSource
import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}