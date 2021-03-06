package com.hishd.cleanarchnewsapp.data.repository

import com.hishd.cleanarchnewsapp.data.model.APIResponse
import com.hishd.cleanarchnewsapp.data.model.Article
import com.hishd.cleanarchnewsapp.data.repository.datasource.NewsRemoteDataSource
import com.hishd.cleanarchnewsapp.data.util.Resource
import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
): NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> = responseToResource(newsRemoteDataSource.getTopHeadLines(country, page))

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(apiResponse: Response<APIResponse>) : Resource<APIResponse> {
        if(apiResponse.isSuccessful) {
            apiResponse.body()?.let { result ->
                return Resource.Success(result)
            }
        }

        return Resource.Error(apiResponse.message())
    }
}