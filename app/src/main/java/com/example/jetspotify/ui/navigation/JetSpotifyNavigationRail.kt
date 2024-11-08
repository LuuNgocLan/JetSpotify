package com.example.jetspotify.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource

@Composable
fun JetSpotifyNavigationRail(
    currentTab: JetSpotifyTab,
    onTabPressed: ((JetSpotifyTab) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.jetSpotifyTab,
                onClick = { onTabPressed(navItem.jetSpotifyTab) },
                icon = {
                    Image(
                        painter = painterResource(id = if (currentTab == navItem.jetSpotifyTab) navItem.selectedIcon else navItem.unSelectedIcon),
                        contentDescription = navItem.text,
                        colorFilter = if (currentTab == navItem.jetSpotifyTab) ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondary) else ColorFilter.tint(
                            color = MaterialTheme.colorScheme.secondary
                        )
                    )
                },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedIconColor = MaterialTheme.colorScheme.secondary,
                )
            )
        }
    }
}
