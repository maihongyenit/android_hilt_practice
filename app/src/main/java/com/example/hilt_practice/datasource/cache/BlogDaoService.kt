package com.example.hilt_practice.datasource.cache

import com.example.hilt_practice.datasource.cache.models.BlogCacheEntity

interface BlogDaoService {

    suspend fun insert(blogEntity: BlogCacheEntity): Long

    suspend fun insert(blogEntities: List<BlogCacheEntity>)

    suspend fun get(): List<BlogCacheEntity>
}