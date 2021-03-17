package com.example.hilt_practice.di

import com.example.hilt_practice.domain.BlogRepo
import com.example.hilt_practice.domain.BlogRepoImpl
import com.example.hilt_practice.domain.data.cache.CacheDataSource
import com.example.hilt_practice.domain.data.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BlogRepoModule {

    @Singleton
    @Provides
    fun provideBlogRepo(
        cacheDataSource: CacheDataSource,
        networkDataSource: NetworkDataSource
    ): BlogRepo {
        return BlogRepoImpl(cacheDataSource, networkDataSource)
    }
}