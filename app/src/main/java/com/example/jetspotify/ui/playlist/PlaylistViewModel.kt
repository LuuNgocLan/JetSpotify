package com.example.jetspotify.ui.playlist

import androidx.lifecycle.ViewModel
import com.example.jetspotify.data.model.Playlist
import com.example.jetspotify.data.repository.PlaylistRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for the playlist detail screen
 */
class PlaylistViewModel : ViewModel() {
    
    private val _playlistState = MutableStateFlow<Playlist?>(null)
    val playlistState: StateFlow<Playlist?> = _playlistState.asStateFlow()
    
    init {
        // Load sample playlist data
        loadPlaylist()
    }
    
    private fun loadPlaylist() {
        // In a real app, this would fetch data from a repository based on a playlist ID
        _playlistState.value = PlaylistRepository.getImaginePlaylist()
    }
}
