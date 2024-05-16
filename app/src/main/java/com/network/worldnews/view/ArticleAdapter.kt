package com.network.worldnews.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.network.worldnews.databinding.ItemArticleBinding
import com.network.worldnews.models.Article

class ArticleAdapter(
    var articles: List<Article>,
    private val onBookmarkClickListener: OnBookmarkClickListener
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){

    interface OnBookmarkClickListener {
          fun onBookmarkClick(article: Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    // Method to update articles
    fun updateArticles(newArticles: List<Article>) {
        articles = newArticles
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.imageViewBookmark.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val article = articles[position]
                    onBookmarkClickListener.onBookmarkClick(article)
                    Log.d("ArticleAdapter", "Bookmark clicked for article: ${article.title}")
                }
            }
        }

        fun bind(article: Article) {
            binding.article = article
            binding.executePendingBindings()

            // Use Glide to load the image from the URL into the ImageView
            Glide.with(binding.root)
                .load(article.urlToImage)
                .into(binding.imageViewArticle)
        }
    }
}
