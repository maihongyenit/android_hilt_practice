package com.example.hilt_practice.datasource.cache.mappers

import com.example.hilt_practice.datasource.cache.models.BlogCacheEntity
import com.example.hilt_practice.datasource.cache.models.blogCache
import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.models.blog
import com.example.hilt_practice.domain.util.EntityMapper

class CacheMapper : EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return blog {
            id = entity.id
            title = entity.title
            body = entity.body
            image = entity.image
            category = entity.category
        }
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return blogCache {
            id = domainModel.id
            title = domainModel.title
            body = domainModel.body
            image = domainModel.image
            category = domainModel.category
        }
    }
}