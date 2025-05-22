package com.jetspotify.ui.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetspotify.data.model.LocalDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EpisodeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(EpisodeUiState())
    val uiState: StateFlow<EpisodeUiState> get() = _uiState

    init {
        onMakeEpisodesSample()
    }

    fun onMakeEpisodesSample() {
        _uiState.value = EpisodeUiState(
            episodes = LocalDataProvider.sampleEpisodeData()
        )
    }

    // ViewModel Provider Factory
    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return EpisodeViewModel() as T
            }
        }
    }
}