package com.example.hilt_practice.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt_practice.datasource.cache.models.BlogCacheEntity

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntities: List<BlogCacheEntity>)

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>
}