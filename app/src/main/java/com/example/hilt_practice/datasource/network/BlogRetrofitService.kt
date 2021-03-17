package com.example.hilt_practice.datasource.network

import com.example.hilt_practice.datasource.network.models.BlogNetworkEntity

interface BlogRetrofitService {

    suspend fun get(): List<BlogNetworkEntity>
}