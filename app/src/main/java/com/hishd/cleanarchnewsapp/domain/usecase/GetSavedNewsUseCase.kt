package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.data.model.Article
import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> = newsRepository.getSavedNews()
}