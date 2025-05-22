package com.jetspotify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FilterChips(
    filterChips: List<String>, selectedTab: String, onTabSelected: (String) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = 0,
        containerColor = Color.Transparent,
        contentColor = Color.White,
        edgePadding = 8.dp,
        indicator = { Spacer(modifier = Modifier) },
        divider = { Spacer(modifier = Modifier) },
        modifier = Modifier.padding()
    ) {
        filterChips.forEach { chip ->
            Tab(
                selected = selectedTab == chip, onClick = { onTabSelected(chip) },
                text = {
                    Text(text = chip, style = MaterialTheme.typography.labelMedium.copy(color = if (selectedTab == chip) Color.Black else Color.White))
                },
                modifier = Modifier
                    .height(36.dp)
                    .padding(2.dp)
                    .background(
                        color = if (selectedTab == chip) Color(0xFF1DB954) else Color.Gray.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(45.dp)
                    ),
            )
        }
    }
}