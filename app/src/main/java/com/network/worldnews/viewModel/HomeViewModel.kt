package com.network.worldnews.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.network.worldnews.models.Article
import com.network.worldnews.repository.NewsRepository
import com.network.worldnews.R
import com.network.worldnews.data.BookmarkDao
import com.network.worldnews.models.Bookmark
import kotlinx.coroutines.launch

class HomeViewModel(private val navController: NavController, private val bookmarkDao: BookmarkDao) : ViewModel() {

    private val repository = NewsRepository()

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    init {
        // Fetch data when ViewModel is created
        getTopHeadlines()
    }

    private fun getTopHeadlines() {
        viewModelScope.launch {
            try {
                val newsData = repository.getTopHeadlines("us", "2c0c55e74fc7411eaf84d62c0e5f6404")
                _articles.value = newsData.articles
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    suspend fun addBookmark(article: Article) {
        val title = article.title ?: ""
        val bookmark = Bookmark(article.id, title, article.description,article.urlToImage)
        bookmarkDao.addBookmark(bookmark)
        Log.d("HomeViewModel", "Bookmark added: $bookmark")
    }


    fun navigateToBookmark() {
        navController.navigate(R.id.action_homeFragment_to_bookmarkFragment)
    }
}
