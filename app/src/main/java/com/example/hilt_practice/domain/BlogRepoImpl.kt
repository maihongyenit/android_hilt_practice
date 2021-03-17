package com.example.hilt_practice.domain

import com.example.hilt_practice.domain.data.cache.CacheDataSource
import com.example.hilt_practice.domain.data.network.NetworkDataSource
import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BlogRepoImpl constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) : BlogRepo {
    override suspend fun getBlogs(): Flow<DataState<List<Blog>>> {
        return flow {
            emit(DataState.Loading)
            delay(1000)
            val networkBlogs = networkDataSource.get()
            cacheDataSource.insertList(networkBlogs)
            val cachedBlog = cacheDataSource.get()
            emit(DataState.Success(cachedBlog))
        }
    }
}