/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jetspotify.ui

import androidx.lifecycle.ViewModel
import com.example.jetspotify.data.JetSpotifyTab
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class JetSpotifyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(JetSpotifyUiState())
    val uiState: StateFlow<JetSpotifyUiState> = _uiState

    //This initialization method was added in the step focused on avoiding unnecessary background work
    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value =
            JetSpotifyUiState(
                // initial value
            )
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                // update value
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentMailbox(jetSpotifyTab: JetSpotifyTab) {
        _uiState.update {
            it.copy(
                // update value
                currentSelectedTab = jetSpotifyTab
            )
        }
    }
}