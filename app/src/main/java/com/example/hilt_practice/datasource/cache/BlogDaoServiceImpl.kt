package com.example.hilt_practice.datasource.cache

import com.example.hilt_practice.datasource.cache.database.BlogDao
import com.example.hilt_practice.datasource.cache.models.BlogCacheEntity

class BlogDaoServiceImpl constructor(private val blogDao: BlogDao) : BlogDaoService {
    override suspend fun insert(blogEntity: BlogCacheEntity): Long {
        return blogDao.insert(blogEntity)
    }

    override suspend fun get(): List<BlogCacheEntity> {
        return blogDao.get()
    }

    override suspend fun insert(blogEntities: List<BlogCacheEntity>) {
        blogDao.insert(blogEntities)
    }
}