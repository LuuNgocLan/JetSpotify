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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.jetspotify.R
import com.jetspotify.ui.home.HomeScreen
import com.jetspotify.ui.library.LibraryScreen
import com.jetspotify.ui.navigation.JetSpotifyBottomNavigationBar
import com.jetspotify.ui.navigation.JetSpotifyDrawerContent
import com.jetspotify.ui.navigation.JetSpotifyNavigationRail
import com.jetspotify.ui.navigation.JetSpotifyTab
import com.jetspotify.ui.navigation.NavigationItemContent
import com.jetspotify.ui.playlist.PlaylistDetailScreen
import com.jetspotify.ui.premium.PremiumScreen
import com.jetspotify.ui.search.SearchScreen
import com.jetspotify.ui.utils.JetSpotifyNavigationType

@Composable
fun JetSpotifyMainScreen(
        modifier: Modifier = Modifier,
        navController: NavHostController,
        navigationType: JetSpotifyNavigationType,
        onTabPressed: (JetSpotifyTab) -> Unit,
        onDetailScreenBackPressed: () -> Unit,
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val navigationItemContentList =
            listOf(
                    NavigationItemContent(
                            jetSpotifyTab = JetSpotifyTab.Home,
                            selectedIcon = R.drawable.ic_home_active,
                            unSelectedIcon = R.drawable.ic_home_inactive,
                            text = stringResource(id = R.string.tab_home)
                    ),
                    NavigationItemContent(
                            jetSpotifyTab = JetSpotifyTab.Search,
                            selectedIcon = R.drawable.ic_search_active,
                            unSelectedIcon = R.drawable.ic_search_inactive,
                            text = stringResource(id = R.string.tab_search)
                    ),
                    NavigationItemContent(
                            jetSpotifyTab = JetSpotifyTab.Library,
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
                                selectedDestination =
                                        currentRoute?.let {
                                            JetSpotifyTab.entries.firstOrNull { e -> e.name == it }
                                        }
                                                ?: JetSpotifyTab.Home,
                                onTabPressed = { jetSpotifyTab -> onTabPressed(jetSpotifyTab) },
                                navItems = navigationItemContentList,
                                modifier =
                                        Modifier.wrapContentWidth()
                                                .fillMaxHeight()
                                                .background(
                                                        MaterialTheme.colorScheme.inverseOnSurface
                                                )
                                                .padding(
                                                        top =
                                                                dimensionResource(
                                                                        R.dimen
                                                                                .drawer_padding_header
                                                                )
                                                )
                                                .testTag(navigationDrawerContentDescription)
                        )
                    }
                },
        ) { JetSpotifyNavHost(navHostController = navController) }
    } else {
        JetSpotifyAppContent(
                navController = navController,
                navigationType = navigationType,
                onTabPressed = onTabPressed,
                navItems = navigationItemContentList,
        )
    }
}

@Composable
private fun JetSpotifyAppContent(
        navController: NavHostController,
        navigationType: JetSpotifyNavigationType,
        onTabPressed: ((JetSpotifyTab) -> Unit),
        navItems: List<NavigationItemContent>
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    Row(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == JetSpotifyNavigationType.NAVIGATION_RAIL) {
            JetSpotifyNavigationRail(
                    navItems = navItems,
                    currentTab =
                            currentRoute?.let {
                                JetSpotifyTab.entries.firstOrNull { e -> e.name == it }
                            }
                                    ?: JetSpotifyTab.Home,
                    onTabPressed = onTabPressed,
            )
        }
        Box(
                modifier =
                        Modifier.fillMaxSize()
                                .align(Alignment.CenterVertically)
                                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            JetSpotifyNavHost(navHostController = navController)
            // Bottom Navigation
            Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)) {
                AnimatedVisibility(
                        visible = navigationType == JetSpotifyNavigationType.BOTTOM_NAVIGATION
                ) {
                    JetSpotifyBottomNavigationBar(
                            currentTab =
                                    currentRoute?.let {
                                        JetSpotifyTab.entries.firstOrNull { e -> e.name == it }
                                    }
                                            ?: JetSpotifyTab.Home,
                            onTabPressed = onTabPressed,
                            navItems = navItems,
                    )
                }
            }
        }
    }
}

@Composable
fun JetSpotifyNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = JetSpotifyTab.Home.name) {
        composable(JetSpotifyTab.Home.name) {
            HomeScreen(
                    onPlaylistClick = { playlistId ->
                        navHostController.navigate("playlist/${playlistId}")
                    }
            )
        }
        composable(JetSpotifyTab.Search.name) { SearchScreen() }
        composable(JetSpotifyTab.Library.name) { LibraryScreen() }
        composable(JetSpotifyTab.Premium.name) { PremiumScreen() }

        // Playlist detail screen
        composable(
                route = "playlist/{playlistId}",
                arguments = listOf(navArgument("playlistId") { type = NavType.StringType })
        ) { backStackEntry ->
            val playlistId = backStackEntry.arguments?.getString("playlistId") ?: ""
            PlaylistDetailScreen(onBackClick = { navHostController.popBackStack() })
        }
    }
}
