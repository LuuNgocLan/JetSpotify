package com.example.jetspotify.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetspotify.data.JetSpotifyTab
import com.example.jetspotify.ui.theme.SpotifyColors


@Composable
fun JetSpotifyDrawerContent(
    selectedDestination: JetSpotifyTab,
    onTabPressed: ((JetSpotifyTab) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        for (navItem in navigationItemContentList) {
            DrawerNavigationItem(
                selected = selectedDestination == navItem.jetSpotifyTab,
                tab = navItem,
                onItemClick = { onTabPressed(navItem.jetSpotifyTab) }
            )
        }
    }
}

@Composable
private fun DrawerNavigationItem(
    tab: NavigationItemContent,
    selected: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        selected = selected,
        onClick = onItemClick,
        color = Color.Transparent,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .height(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .width(4.dp)
                    .background(if (selected) SpotifyColors.SpotifyGreen else Color.Transparent)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = if (selected) tab.selectedIcon else tab.unSelectedIcon),
                contentDescription = tab.text
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = tab.text,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }
    }
}