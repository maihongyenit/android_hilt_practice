package com.example.hilt_practice.datasource.network.mappers

import com.example.hilt_practice.datasource.network.models.BlogNetworkEntity
import com.example.hilt_practice.datasource.network.models.blogNetwork
import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.models.blog
import com.example.hilt_practice.domain.util.EntityMapper

class NetworkMapper : EntityMapper<BlogNetworkEntity, Blog> {
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return blog {
            id = entity.id
            title = entity.title
            body = entity.body
            image = entity.image
            category = entity.category
        }
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return blogNetwork {
            id = domainModel.id
            title = domainModel.title
            body = domainModel.body
            image = domainModel.image
            category = domainModel.category
        }
    }
}