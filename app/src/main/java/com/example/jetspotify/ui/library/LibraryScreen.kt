package com.example.jetspotify.ui.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetspotify.ui.components.Avatar
import com.example.jetspotify.ui.theme.SpotifyColors

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpotifyColors.SpotifyDarkGrey)
    ) {
        Row {
            Avatar()
            Text(text = "Search")
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}