package com.hishd.cleanarchnewsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hishd.cleanarchnewsapp.data.util.Resource
import com.hishd.cleanarchnewsapp.databinding.FragmentNewsBinding
import com.hishd.cleanarchnewsapp.presentation.adapter.NewsAdapter
import com.hishd.cleanarchnewsapp.presentation.viewmodel.NewsViewModel

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewModel: NewsViewModel

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setupRecyclerView()
        loadNewsList()
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        with(binding.recyclerNews) {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun changeProgressState(state: ProgressState) {
        when(state) {
            ProgressState.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ProgressState.DONE -> {
                binding.progressBar.visibility = View.INVISIBLE
            }
        }
    }

    private fun loadNewsList() {
        viewModel.getNewsHeadlines("us", 1)
        viewModel.response.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    changeProgressState(ProgressState.DONE)
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles.toList())
                    }
                }
                is Resource.Loading -> {
                    changeProgressState(ProgressState.LOADING)
                }
                is Resource.Error -> {
                    changeProgressState(ProgressState.DONE)
                    response.message?.let {
                        Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    enum class ProgressState {
        LOADING, DONE
    }
}