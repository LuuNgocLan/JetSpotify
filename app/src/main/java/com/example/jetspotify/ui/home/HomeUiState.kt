package com.example.jetspotify.ui.home

import com.example.jetspotify.data.model.Category
import com.example.jetspotify.model.Album
import com.example.jetspotify.data.model.SpotifyPlaylist
import com.example.jetspotify.data.model.Show

data class HomeUiState(
    val userPlayList: List<SpotifyPlaylist> = emptyList(),
    val albums: List<Album> = emptyList(),
    val categories: List<Category> = emptyList(),
    val shows: List<Show> = emptyList(),
)