package com.example.hilt_practice.domain

import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.state.DataState
import kotlinx.coroutines.flow.Flow

interface BlogRepo {

    suspend fun getBlogs(): Flow<DataState<List<Blog>>>
}