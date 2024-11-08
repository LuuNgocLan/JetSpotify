package com.example.jetspotify.model

import kotlinx.serialization.Serializable

@Serializable
data class Tracks(
    val href: String,
    val limit: Long,
    val offset: Long,
    val next: String,
    val previous: String,
    val total: Long,
    val items: List<Item>
)
