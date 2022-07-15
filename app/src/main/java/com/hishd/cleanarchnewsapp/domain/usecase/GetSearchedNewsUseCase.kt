package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}