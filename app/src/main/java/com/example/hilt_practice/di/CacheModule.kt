package com.example.hilt_practice.di

import android.content.Context
import androidx.room.Room
import com.example.hilt_practice.datasource.cache.BlogDaoService
import com.example.hilt_practice.datasource.cache.BlogDaoServiceImpl
import com.example.hilt_practice.datasource.cache.database.BlogDao
import com.example.hilt_practice.datasource.cache.database.BlogDatabase
import com.example.hilt_practice.datasource.cache.mappers.CacheMapper
import com.example.hilt_practice.domain.data.cache.CacheDataSource
import com.example.hilt_practice.domain.data.cache.CacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheDataSource(
        blogDaoService: BlogDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(blogDaoService, cacheMapper)
    }

    @Singleton
    @Provides
    fun provideBlogDaoService(blogDao: BlogDao): BlogDaoService {
        return BlogDaoServiceImpl(blogDao)
    }

    @Provides
    fun provideBlogDao(db: BlogDatabase): BlogDao {
        return db.blogDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideCacheMapper() = CacheMapper()
}