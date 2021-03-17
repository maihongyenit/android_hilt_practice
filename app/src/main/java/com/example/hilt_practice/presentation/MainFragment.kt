package com.example.hilt_practice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hilt_practice.R
import com.example.hilt_practice.databinding.FragmentMainBinding
import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.state.DataState

class MainFragment : Fragment() {

    private lateinit var databinding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        databinding.lifecycleOwner = viewLifecycleOwner
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogsEvent)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            when (dataState) {
                is DataState.Success -> {
                    displayProgressBar(false)
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.throwable.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message != null) databinding.text.text = message else databinding.text.text =
            "Unknown error."
    }

    private fun appendBlogTitles(blogs: List<Blog>) {
        val sb = StringBuilder()
        for (blog in blogs) {
            sb.append(blog.title + "\n")
        }
        databinding.text.text = sb.toString()
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        databinding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}