package com.jetspotify.ui.navigation

import androidx.annotation.DrawableRes

data class NavigationItemContent(
    val jetSpotifyTab: JetSpotifyTab,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int,
    val text: String
)
