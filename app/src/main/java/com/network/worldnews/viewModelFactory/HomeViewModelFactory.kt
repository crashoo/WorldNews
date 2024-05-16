package com.network.worldnews.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.network.worldnews.viewModel.HomeViewModel
import com.network.worldnews.data.BookmarkDao

class HomeViewModelFactory(private val navController: NavController, private val bookmarkDao: BookmarkDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(navController, bookmarkDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
