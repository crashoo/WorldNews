package com.network.worldnews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.network.worldnews.databinding.FragmentHomeBinding
import com.network.worldnews.models.Article
import com.network.worldnews.data.BookmarkDatabase
import com.network.worldnews.viewModel.HomeViewModel
import com.network.worldnews.viewModelFactory.HomeViewModelFactory
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), ArticleAdapter.OnBookmarkClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ArticleAdapter

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(
            NavHostFragment.findNavController(this),
            BookmarkDatabase.getInstance(requireContext()).bookmarkDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Bind the ViewModel to the layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArticleAdapter(emptyList(), this) // Pass 'this' as the onBookmarkClickListener
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.articles.observe(viewLifecycleOwner) { articles ->
            adapter.updateArticles(articles)
        }

        // Set up onClick listener for bookmark text
        binding.textViewBookmark.setOnClickListener {
            viewModel.navigateToBookmark()
        }
    }

    override fun onBookmarkClick(article: Article) {
        // Call the suspend function within a coroutine scope
        lifecycleScope.launch {
            viewModel.addBookmark(article)
        }
    }
}
