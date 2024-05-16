package com.network.worldnews.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.network.worldnews.models.Bookmark

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(bookmark: Bookmark)

    @Delete
    suspend fun removeBookmark(bookmark: Bookmark)

    @Query("SELECT * FROM bookmark")
    fun getAllBookmarks(): LiveData<List<Bookmark>>
}
