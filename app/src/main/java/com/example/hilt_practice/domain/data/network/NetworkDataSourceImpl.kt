package com.example.hilt_practice.domain.data.network

import com.example.hilt_practice.datasource.network.BlogRetrofitService
import com.example.hilt_practice.datasource.network.mappers.NetworkMapper
import com.example.hilt_practice.domain.models.Blog

class NetworkDataSourceImpl constructor(
    private val blogRetrofitService: BlogRetrofitService,
    private val networkMapper: NetworkMapper
) : NetworkDataSource {
    override suspend fun get(): List<Blog> {
        return blogRetrofitService.get().map { networkMapper.mapFromEntity(it) }
    }
}