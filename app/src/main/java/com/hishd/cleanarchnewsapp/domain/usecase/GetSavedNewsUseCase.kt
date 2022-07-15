package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}