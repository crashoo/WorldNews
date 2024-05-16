package com.network.worldnews.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.network.worldnews.viewModel.BookmarkViewModel
import com.network.worldnews.data.BookmarkDao
import com.network.worldnews.repository.BookmarkRepository

class BookmarkViewModelFactory(private val bookmarkDao: BookmarkDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookmarkViewModel::class.java)) {
            return BookmarkViewModel(BookmarkRepository(bookmarkDao)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
