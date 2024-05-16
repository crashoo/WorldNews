package com.network.worldnews.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.network.worldnews.models.Bookmark
import com.network.worldnews.repository.BookmarkRepository
import kotlinx.coroutines.launch

class BookmarkViewModel(private val repository: BookmarkRepository) : ViewModel() {

    val bookmarkedArticles: LiveData<List<Bookmark>> = repository.bookmarkedArticles

    fun removeBookmark(bookmark: Bookmark) {
        viewModelScope.launch {
            repository.removeBookmark(bookmark)
        }
    }

}
