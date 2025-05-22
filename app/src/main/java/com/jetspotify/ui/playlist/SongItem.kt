package com.jetspotify.ui.playlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jetspotify.data.model.Song

/**
 * Composable for displaying a song item in a playlist
 */
@Composable
fun SongItem(
    song: Song,
    onSongClick: (Song) -> Unit,
    onMoreClick: (Song) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSongClick(song) }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Album cover
        AsyncImage(
            model = song.albumCoverUrl,
            contentDescription = "${song.title} album cover",
            modifier = Modifier
                .size(48.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        // Song info
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        // Duration
        Text(
            text = song.duration,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        // More options
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More options",
            modifier = Modifier
                .size(24.dp)
                .clickable { onMoreClick(song) },
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}
