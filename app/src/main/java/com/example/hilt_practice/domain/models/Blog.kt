package com.example.hilt_practice.domain.models

import kotlin.properties.Delegates

data class Blog(
    val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val category: String
)

class BlogBuilder {
    var id: Int by Delegates.notNull()
    var title: String by Delegates.notNull()
    var body: String by Delegates.notNull()
    var image: String by Delegates.notNull()
    var category: String by Delegates.notNull()

    fun build(): Blog {
        return Blog(id, title, body, image, category)
    }
}

fun blog(init: BlogBuilder.() -> Unit): Blog {
    return BlogBuilder().apply(init).build()
}
