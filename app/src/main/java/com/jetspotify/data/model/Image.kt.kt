package com.jetspotify.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val height: Long? = null,
    val url: String,
    val width: Long? = null
)