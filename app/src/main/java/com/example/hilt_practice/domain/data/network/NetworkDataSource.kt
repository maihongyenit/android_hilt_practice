package com.example.hilt_practice.domain.data.network

import com.example.hilt_practice.domain.models.Blog

interface NetworkDataSource {
    suspend fun get(): List<Blog>
}