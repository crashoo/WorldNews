package com.network.worldnews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.network.worldnews.data.BookmarkDatabase
import com.network.worldnews.databinding.FragmentBookmarkBinding
import com.network.worldnews.viewModel.BookmarkViewModel
import com.network.worldnews.viewModelFactory.BookmarkViewModelFactory

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var adapter: BookmarkAdapter

    private val viewModel: BookmarkViewModel by viewModels {
        BookmarkViewModelFactory(
            BookmarkDatabase.getInstance(requireContext()).bookmarkDao()
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner // Set the lifecycle owner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BookmarkAdapter { /* handle item click here */ }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter // Set the adapter to the RecyclerView

        viewModel.bookmarkedArticles.observe(viewLifecycleOwner) { bookmarks ->
            adapter.submitList(bookmarks)
        }
    }
}
