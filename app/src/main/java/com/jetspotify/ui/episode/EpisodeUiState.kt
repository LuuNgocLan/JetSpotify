package com.jetspotify.ui.episode

import com.jetspotify.model.Episode

data class EpisodeUiState(
    val episodes: List<Episode> = emptyList(),
    val isPlaying: Boolean = false,
    val selectedTab: Int = 0
)