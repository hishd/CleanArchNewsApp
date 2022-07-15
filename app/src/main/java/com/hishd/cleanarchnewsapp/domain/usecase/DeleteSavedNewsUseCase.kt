package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.data.model.Article
import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}