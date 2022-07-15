package com.hishd.cleanarchnewsapp.presentation.di

import com.hishd.cleanarchnewsapp.BuildConfig
import com.hishd.cleanarchnewsapp.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsAPIService(retrofit: Retrofit) : NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }
}
//Step 02: Create module classes for each class created in data, domain & presentation which requires constructor dependencies