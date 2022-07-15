package com.hishd.cleanarchnewsapp.domain.repository

import com.hishd.cleanarchnewsapp.data.model.APIResponse
import com.hishd.cleanarchnewsapp.data.model.Article
import com.hishd.cleanarchnewsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    //Functions related to the network related operations
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    //Functions related to the Local data related operations
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}