package com.jetspotify.model

data class Episode(
    val id: String,
    val title: String,
    val speaker: String,
    val showName: String,
    val publishDate: String,
    val duration: String,
    val description: String,
    val thumbnailUrl: String,
    val isPlaying: Boolean = false,
    val isDownloaded: Boolean = false,
)
