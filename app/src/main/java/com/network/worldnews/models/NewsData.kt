package com.network.worldnews.models


data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)