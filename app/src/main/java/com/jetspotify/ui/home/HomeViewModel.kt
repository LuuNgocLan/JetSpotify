package com.jetspotify.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    /**
     * Factory for creating instances of HomeViewModel with dependencies
     */
    companion object {
        fun provideFactory(
            /// homeRepository: HomeRepo = HomeRepo
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel() as T
            }
        }
    }
}