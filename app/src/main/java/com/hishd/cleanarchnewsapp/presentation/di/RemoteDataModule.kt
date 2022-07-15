package com.hishd.cleanarchnewsapp.presentation.di

import com.hishd.cleanarchnewsapp.data.api.NewsAPIService
import com.hishd.cleanarchnewsapp.data.repository.datasource.NewsRemoteDataSource
import com.hishd.cleanarchnewsapp.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Provides
    @Singleton
    fun providesRemoteDataSource(service: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(service)
    }
}