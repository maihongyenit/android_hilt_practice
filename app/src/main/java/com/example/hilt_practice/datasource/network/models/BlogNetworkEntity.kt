package com.example.hilt_practice.datasource.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.properties.Delegates

data class BlogNetworkEntity(
    @SerializedName("pk")
    @Expose
    val id: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("body")
    @Expose
    val body: String,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("category")
    @Expose
    val category: String
)

class BlogNetworkEntityBuilder {
    var id: Int by Delegates.notNull()
    var title: String by Delegates.notNull()
    var body: String by Delegates.notNull()
    var image: String by Delegates.notNull()
    var category: String by Delegates.notNull()

    fun build(): BlogNetworkEntity {
        return BlogNetworkEntity(id, title, body, image, category)
    }
}

fun blogNetwork(init: BlogNetworkEntityBuilder.() -> Unit): BlogNetworkEntity {
    return BlogNetworkEntityBuilder().apply(init).build()
}