package com.example.jetspotify.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetspotify.data.JetSpotifyTab


@Composable
fun JetSpotifyBottomNavigationBar(
//    navController: NavController,
    currentTab: JetSpotifyTab,
    onTabPressed: ((JetSpotifyTab) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {

    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
        tonalElevation = 0.dp,
        windowInsets = WindowInsets.navigationBars,
    ) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                interactionSource = remember { MutableInteractionSource() },
                label = {
                    Text(
                        navItem.text,
                        color = if (currentTab == navItem.jetSpotifyTab) Color.White else Color.LightGray
                    )
                },
                selected = currentTab == navItem.jetSpotifyTab,
                onClick = { onTabPressed(navItem.jetSpotifyTab) },
                icon = {
                    Image(
                        painter = painterResource(id = if (currentTab == navItem.jetSpotifyTab) navItem.selectedIcon else navItem.unSelectedIcon),
                        contentDescription = navItem.text,
                        colorFilter = if (currentTab == navItem.jetSpotifyTab) ColorFilter.tint(
                            Color.White
                        ) else ColorFilter.tint(Color.LightGray)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}