package com.hishd.cleanarchnewsapp.presentation.di

import android.app.Application
import com.hishd.cleanarchnewsapp.domain.usecase.GetNewsHeadlinesUseCase
import com.hishd.cleanarchnewsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun providesNewsViewModelFactory(app: Application, getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ) : NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase)
    }
}