package com.example.hilt_practice.datasource.cache.database

import androidx.room.RoomDatabase

abstract class BlogDatabase : RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object {
        const val DATABASE_NAME = "blog_db"
    }
}