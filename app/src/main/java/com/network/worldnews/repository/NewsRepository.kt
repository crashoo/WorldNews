package com.network.worldnews.repository

import com.network.worldnews.models.NewsData
import com.network.worldnews.data.RetrofitClient

class NewsRepository {

    suspend fun getTopHeadlines(country: String, apiKey: String): NewsData {
        return RetrofitClient.apiService.getTopHeadlines(country, apiKey)
    }

}
