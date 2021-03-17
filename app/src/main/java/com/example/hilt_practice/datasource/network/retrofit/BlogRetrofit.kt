package com.example.hilt_practice.datasource.network.retrofit

import com.example.hilt_practice.datasource.network.models.BlogNetworkEntity
import retrofit2.http.GET

interface BlogRetrofit {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}