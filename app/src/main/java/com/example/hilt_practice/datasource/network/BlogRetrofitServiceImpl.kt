package com.example.hilt_practice.datasource.network

import com.example.hilt_practice.datasource.network.models.BlogNetworkEntity
import com.example.hilt_practice.datasource.network.retrofit.BlogRetrofit

class BlogRetrofitServiceImpl constructor(private val blogRetrofit: BlogRetrofit) :
    BlogRetrofitService {
    override suspend fun get(): List<BlogNetworkEntity> {
        return blogRetrofit.get()
    }
}