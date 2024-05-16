// BookmarkAdapter.kt
package com.network.worldnews.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.network.worldnews.databinding.ItemBookmarkBinding
import com.network.worldnews.models.Bookmark

class BookmarkAdapter(
    private val onItemClick: (Bookmark) -> Unit
) : ListAdapter<Bookmark, BookmarkAdapter.BookmarkViewHolder>(BookmarkDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val bookmark = getItem(position)
        holder.bind(bookmark)
    }

    inner class BookmarkViewHolder(private val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val bookmark = getItem(position)
                    onItemClick(bookmark)
                }
            }
        }

        fun bind(bookmark: Bookmark) {
            binding.bookmark = bookmark
            binding.executePendingBindings()

            Glide.with(binding.root)
                .load(bookmark.urlToImage)
                .into(binding.imageViewArticle)
        }
    }

    class BookmarkDiffCallback : DiffUtil.ItemCallback<Bookmark>() {
        override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
            return oldItem == newItem
        }
    }
}
