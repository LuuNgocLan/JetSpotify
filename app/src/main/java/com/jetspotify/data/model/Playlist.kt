package com.jetspotify.data.model

data class Playlist(
    val id: String,
    val title: String,
    val description: String,
    val coverUrl: String,
    val creator: String,
    val followers: Int,
    val duration: String,
    val songs: List<Song> = emptyList()
)

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val albumCoverUrl: String,
    val duration: String
)
