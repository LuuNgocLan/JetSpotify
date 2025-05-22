package com.jetspotify.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetspotify.ui.theme.SpotifyPalette

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpotifyPalette.darkGrey),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Search Screen")
    }
}
