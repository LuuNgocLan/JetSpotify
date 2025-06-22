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
package com.jetspotify.ui.main

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jetspotify.ui.navigation.JetSpotifyTab
import com.jetspotify.ui.navigation.rememberJetSpotifyNavController
import com.jetspotify.ui.utils.JetSpotifyNavigationType

@Composable
fun JetSpotifyApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navHostController = rememberJetSpotifyNavController()

    val navigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> JetSpotifyNavigationType.BOTTOM_NAVIGATION
        WindowWidthSizeClass.Medium -> JetSpotifyNavigationType.NAVIGATION_RAIL
        WindowWidthSizeClass.Expanded -> JetSpotifyNavigationType.PERMANENT_NAVIGATION_DRAWER
        else -> JetSpotifyNavigationType.BOTTOM_NAVIGATION
    }

    JetSpotifyMainScreen(
        navController = navHostController.navController,
        navigationType = navigationType,
        onTabPressed = { jetSpotifyTab: JetSpotifyTab ->
            navHostController.navigateToBottomBarRoute(jetSpotifyTab.name)
        },
        modifier = modifier
    )
}

