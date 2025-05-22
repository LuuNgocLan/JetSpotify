package com.jetspotify.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetspotify.ui.components.Avatar

@Composable
fun HomeTopBar() {
    val filterChips = listOf<String>(
        "All", "Music", "Podcasts"
    )
    val selectedTab = rememberSaveable { mutableStateOf(filterChips.first()) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Avatar()
        FilterChips(filterChips = filterChips,
            selectedTab = selectedTab.value,
            onTabSelected = { selectedTab.value = it })
    }
}
