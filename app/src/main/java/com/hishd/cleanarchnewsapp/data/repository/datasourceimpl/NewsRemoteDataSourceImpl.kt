package com.hishd.cleanarchnewsapp.data.repository.datasourceimpl

import com.hishd.cleanarchnewsapp.data.api.NewsAPIService
import com.hishd.cleanarchnewsapp.data.model.APIResponse
import com.hishd.cleanarchnewsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val country: String,
    private val page: Int,
    private val service: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<APIResponse> = service.getTopHeadlines(country, page)
}