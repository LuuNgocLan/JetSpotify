package com.jetspotify.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    val items: List<Category>? = null
)

@Serializable
data class Category(
    val href: String?,
    val icons: List<Icon>,
    val id: String?,
    val name: String
)

@Serializable
data class Icon(
    val url: String?,
    val height: Long?,
    val width: Long?,
)
