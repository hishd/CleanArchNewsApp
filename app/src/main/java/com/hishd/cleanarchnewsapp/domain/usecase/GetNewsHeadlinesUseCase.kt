package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.data.model.APIResponse
import com.hishd.cleanarchnewsapp.data.util.Resource
import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> = newsRepository.getNewsHeadlines(country, page)
}