package com.example.jetspotify.ui.episode

import com.example.jetspotify.model.Episode

data class EpisodeUiState(
    val episodes: List<Episode> = emptyList(),
    val isPlaying: Boolean = false,
    val selectedTab: Int = 0
)