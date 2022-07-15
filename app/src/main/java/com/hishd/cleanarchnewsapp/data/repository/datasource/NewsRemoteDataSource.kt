package com.hishd.cleanarchnewsapp.data.repository.datasource

import com.hishd.cleanarchnewsapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines() : Response<APIResponse>
}