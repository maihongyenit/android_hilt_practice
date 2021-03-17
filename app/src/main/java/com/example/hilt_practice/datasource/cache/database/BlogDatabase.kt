package com.example.hilt_practice.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt_practice.datasource.cache.models.BlogCacheEntity

@Database(entities = [BlogCacheEntity::class ], version = 1)
abstract class BlogDatabase : RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object {
        const val DATABASE_NAME = "blog_db"
    }
}