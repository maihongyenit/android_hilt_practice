package com.example.hilt_practice.domain.data.cache

import com.example.hilt_practice.domain.models.Blog

interface CacheDataSource {
    suspend fun insert(blog: Blog): Long
    suspend fun insertList(blogs: List<Blog>)
    suspend fun get(): List<Blog>
}