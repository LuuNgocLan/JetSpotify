package com.example.jetspotify.ui.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetspotify.ui.theme.SpotifyColors

@Composable
fun PremiumScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpotifyColors.SpotifyDarkGrey)
    ) {
        Text(text = "Premium")
    }
}