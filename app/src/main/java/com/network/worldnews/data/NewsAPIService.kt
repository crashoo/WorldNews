// NewsAPIService.kt
package com.network.worldnews.data

import com.network.worldnews.models.NewsData
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String="us", // You can adjust query parameters as needed
        @Query("apiKey") apiKey: String="2c0c55e74fc7411eaf84d62c0e5f6404"
    ): NewsData
}
