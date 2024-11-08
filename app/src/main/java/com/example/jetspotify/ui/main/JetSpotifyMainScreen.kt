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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.jetspotify.R
import com.example.jetspotify.ui.home.HomeScreen
import com.example.jetspotify.ui.navigation.JetSpotifyBottomNavigationBar
import com.example.jetspotify.ui.navigation.JetSpotifyDrawerContent
import com.example.jetspotify.ui.navigation.JetSpotifyNavigationRail
import com.example.jetspotify.ui.navigation.JetSpotifyTab
import com.example.jetspotify.ui.navigation.NavigationItemContent
import com.example.jetspotify.ui.utils.JetSpotifyContentType
import com.example.jetspotify.ui.utils.JetSpotifyNavigationType

@Composable
fun JetSpotifyMainScreen(
    navigationType: JetSpotifyNavigationType,
    contentType: JetSpotifyContentType,
    jetSpotifyUiState: JetSpotifyUiState,
    onTabPressed: (JetSpotifyTab) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            jetSpotifyTab = JetSpotifyTab.Home,
            selectedIcon = R.drawable.ic_home_active,
            unSelectedIcon = R.drawable.ic_home_inactive,
            text = stringResource(id = R.string.tab_home)
        ),
        NavigationItemContent(
            jetSpotifyTab = JetSpotifyTab.Library,
            selectedIcon = R.drawable.ic_search_active,
            unSelectedIcon = R.drawable.ic_search_inactive,
            text = stringResource(id = R.string.tab_search)
        ),
        NavigationItemContent(
            jetSpotifyTab = JetSpotifyTab.Search,
            selectedIcon = R.drawable.ic_library_active,
            unSelectedIcon = R.drawable.ic_library_inactive,
            text = stringResource(id = R.string.tab_library)
        ),
        NavigationItemContent(
            jetSpotifyTab = JetSpotifyTab.Premium,
            selectedIcon = R.drawable.ic_spotify_selected,
            unSelectedIcon = R.drawable.ic_spotify_unselected,
            text = stringResource(id = R.string.tab_premium)
        )
    )
    if (navigationType == JetSpotifyNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                    JetSpotifyDrawerContent(
                        selectedDestination = jetSpotifyUiState.currentSelectedTab,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(top = dimensionResource(R.dimen.drawer_padding_header))
                            .testTag(navigationDrawerContentDescription)
                    )
                }
            },
        ) {
            // Main Nav host content
            HomeScreen()
        }
    } else {
        JetSpotifyAppContent(
            navigationType = navigationType,
            contentType = contentType,
            jetSpotifyUiState = jetSpotifyUiState,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = modifier
        )
    }
}

@Composable
private fun JetSpotifyAppContent(
    navigationType: JetSpotifyNavigationType,
    contentType: JetSpotifyContentType,
    jetSpotifyUiState: JetSpotifyUiState,
    onTabPressed: ((JetSpotifyTab) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    Row(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == JetSpotifyNavigationType.NAVIGATION_RAIL) {
            val navigationRailContentDescription = stringResource(R.string.navigation_rail)
            JetSpotifyNavigationRail(
                currentTab = jetSpotifyUiState.currentSelectedTab,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            // Main Nav host content
            Box(modifier = Modifier.fillMaxSize()) {
                HomeScreen()
            }
            // Bottom Navigation
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                AnimatedVisibility(visible = navigationType == JetSpotifyNavigationType.BOTTOM_NAVIGATION) {
                    JetSpotifyBottomNavigationBar(
                        currentTab = jetSpotifyUiState.currentSelectedTab,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,

                        )
                }
            }

        }

    }
}
