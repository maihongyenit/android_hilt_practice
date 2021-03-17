package com.example.hilt_practice.domain.data.cache

import com.example.hilt_practice.datasource.cache.BlogDaoService
import com.example.hilt_practice.datasource.cache.mappers.CacheMapper
import com.example.hilt_practice.domain.models.Blog

class CacheDataSourceImpl constructor(
    private val blogDaoService: BlogDaoService,
    private val cacheMapper: CacheMapper
) : CacheDataSource {
    override suspend fun insert(blog: Blog): Long {
        return blogDaoService.insert(cacheMapper.mapToEntity(blog))
    }

    override suspend fun insertList(blogs: List<Blog>) {
        val list = blogs.map { cacheMapper.mapToEntity(it) }
        blogDaoService.insert(list)
    }

    override suspend fun get(): List<Blog> {
        return blogDaoService.get().map { cacheMapper.mapFromEntity(it) }
    }
}