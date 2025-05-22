package com.jetspotify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun Avatar() {
    AsyncImage(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(color = Color.Gray.copy(alpha = 0.5f)),

        model = "https://images.unsplash.com/photo-1730201955888-a0eb46d4fe02?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        contentDescription = "Avatar",
//            placeholder = painterResource(drawable.ic_menu_camera),
        contentScale = ContentScale.Crop,
    )
}