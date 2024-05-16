package com.network.worldnews.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.network.worldnews.data.BookmarkDao
import com.network.worldnews.data.BookmarkDatabase
import com.network.worldnews.models.Bookmark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookmarkRepository(private val bookmarkDao: BookmarkDao) {

    companion object {
        @Volatile
        private var INSTANCE: BookmarkRepository? = null

        fun getInstance(context: Context): BookmarkRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = BookmarkRepository(BookmarkDatabase.getInstance(context).bookmarkDao())
                INSTANCE = instance
                instance
            }
        }
    }

    val bookmarkedArticles: LiveData<List<Bookmark>> = bookmarkDao.getAllBookmarks()

    suspend fun addBookmark(bookmark: Bookmark) {
        // Add logging statement here to check if the bookmark is being added
        println("Adding bookmark: $bookmark")

        // Use coroutine withContext to switch to IO dispatcher for database operation
        withContext(Dispatchers.IO) {
            bookmarkDao.addBookmark(bookmark)
        }
    }

    suspend fun removeBookmark(bookmark: Bookmark) {
        bookmarkDao.removeBookmark(bookmark)
    }

}
