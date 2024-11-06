package com.example.jetspotify.ui.navigation

import androidx.annotation.DrawableRes
import com.example.jetspotify.data.JetSpotifyTab

data class NavigationItemContent(
    val jetSpotifyTab: JetSpotifyTab,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int,
    val text: String
)
