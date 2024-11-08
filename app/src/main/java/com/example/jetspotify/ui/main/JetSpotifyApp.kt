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
package com.example.jetspotify.ui.main

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jetspotify.ui.navigation.JetSpotifyTab
import com.example.jetspotify.ui.utils.JetSpotifyContentType
import com.example.jetspotify.ui.utils.JetSpotifyNavigationType

@Composable
fun JetSpotifyApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: JetSpotifyNavigationType
    val contentType: JetSpotifyContentType
    val viewModel: JetSpotifyViewModel = viewModel()
    val jetSpotifyUiState = viewModel.uiState.collectAsState().value
    val navController = rememberNavController()

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = JetSpotifyNavigationType.BOTTOM_NAVIGATION
            contentType = JetSpotifyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = JetSpotifyNavigationType.NAVIGATION_RAIL
            contentType = JetSpotifyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = JetSpotifyNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = JetSpotifyContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = JetSpotifyNavigationType.BOTTOM_NAVIGATION
            contentType = JetSpotifyContentType.LIST_ONLY
        }
    }
    JetSpotifyMainScreen(
        navigationType = navigationType,
        contentType = contentType,
        jetSpotifyUiState = jetSpotifyUiState,
        onTabPressed = { jetSpotifyTab: JetSpotifyTab ->
            viewModel.updateCurrentMailbox(jetSpotifyTab = jetSpotifyTab)
            viewModel.resetHomeScreenStates()
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}
