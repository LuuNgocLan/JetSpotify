package com.jetspotify.ui.home

import com.jetspotify.data.model.Category
import com.jetspotify.model.Album
import com.jetspotify.data.model.SpotifyPlaylist
import com.jetspotify.data.model.Show

data class HomeUiState(
    val userPlayList: List<SpotifyPlaylist> = emptyList(),
    val albums: List<Album> = emptyList(),
    val categories: List<Category> = emptyList(),
    val shows: List<Show> = emptyList(),
)