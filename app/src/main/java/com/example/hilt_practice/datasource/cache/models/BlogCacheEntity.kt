package com.example.hilt_practice.datasource.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

@Entity(tableName = "blogs")
data class BlogCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "body")
    val body: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "category")
    val category: String
)

class BlogCacheEntityBuilder {
    var id: Int by Delegates.notNull()
    var title: String by Delegates.notNull()
    var body: String by Delegates.notNull()
    var image: String by Delegates.notNull()
    var category: String by Delegates.notNull()

    fun build(): BlogCacheEntity {
        return BlogCacheEntity(id, title, body, image, category)
    }
}

fun blogCache(init: BlogCacheEntityBuilder.() -> Unit): BlogCacheEntity {
    return BlogCacheEntityBuilder().apply(init).build()
}