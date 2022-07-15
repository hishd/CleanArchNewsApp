package com.hishd.cleanarchnewsapp.domain.usecase

import com.hishd.cleanarchnewsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}