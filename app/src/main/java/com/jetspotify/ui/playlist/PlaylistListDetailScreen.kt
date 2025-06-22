package com.jetspotify.ui.playlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jetspotify.ui.components.AdaptiveListDetailLayout

/**
 * A screen that demonstrates the list-detail pattern using Material 3's canonical layout components.
 * This screen shows a list of playlists on one side and the selected playlist's details on the other.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistListDetailScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Sample data
    val playlists = remember {
        listOf(
            Playlist("1", "Today's Top Hits", "The hottest tracks right now", 50),
            Playlist("2", "RapCaviar", "New music from the biggest names in Hip-Hop", 55),
            Playlist("3", "Rock Classics", "Rock legends & epic songs", 100),
            Playlist("4", "Peaceful Piano", "Relax and indulge with beautiful piano pieces", 120),
            Playlist("5", "Deep Focus", "Keep calm and focus with ambient and post-rock music", 90),
            Playlist("6", "Indie Mix", "The best new indie music", 75),
            Playlist("7", "Jazz Vibes", "The perfect jazz for your evening", 65),
            Playlist("8", "Chill Hits", "Kick back to the best new chill hits", 80),
            Playlist("9", "Electronic Mix", "From deep house to EDM", 95),
            Playlist("10", "Workout Beats", "Energy tracks to power your workout", 60)
        )
    }
    
    var selectedPlaylistId by remember { mutableStateOf<String?>(null) }
    var showDetailOnly by remember { mutableStateOf(false) }
    
    // Handle back button press in compact mode
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        BackHandler(enabled = showDetailOnly) {
            showDetailOnly = false
        }
    }
    
    // In compact mode, we'll navigate between list and detail
    // In other modes, we'll show both simultaneously
    val selectedPlaylist = playlists.find { it.id == selectedPlaylistId }
    
    AdaptiveListDetailLayout(
        windowWidthSizeClass = windowWidthSizeClass,
        showDetailOnly = showDetailOnly,
        hasDetailContent = selectedPlaylist != null,
        listContent = {
            PlaylistListContent(
                playlists = playlists,
                selectedPlaylistId = selectedPlaylistId,
                onPlaylistSelected = { playlistId ->
                    selectedPlaylistId = playlistId
                    // In compact mode, show detail view
                    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
                        showDetailOnly = true
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        },
        detailContent = {
            if (selectedPlaylist != null) {
                PlaylistDetailContent(
                    playlist = selectedPlaylist,
                    onBackClick = if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
                        { showDetailOnly = false }
                    } else null,
                    isCompactMode = windowWidthSizeClass == WindowWidthSizeClass.Compact,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                EmptyDetailContent()
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlaylistListContent(
    playlists: List<Playlist>,
    selectedPlaylistId: String?,
    onPlaylistSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Playlists") }
            )
        },
        modifier = modifier
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(playlists) { playlist ->
                PlaylistItem(
                    playlist = playlist,
                    isSelected = playlist.id == selectedPlaylistId,
                    onClick = { onPlaylistSelected(playlist.id) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlaylistDetailContent(
    playlist: Playlist,
    onBackClick: (() -> Unit)? = null,
    isCompactMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            if (isCompactMode && onBackClick != null) {
                TopAppBar(
                    title = { Text(playlist.name) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            } else {
                TopAppBar(
                    title = { Text(playlist.name) }
                )
            }
        },
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Playlist header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Playlist cover
                Card(
                    modifier = Modifier.size(120.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MusicNote,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column {
                    Text(
                        text = playlist.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(
                        text = playlist.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "${playlist.trackCount} songs",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Track list
            Text(
                text = "Tracks",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Sample tracks
            for (i in 1..10) {
                TrackItem(
                    trackNumber = i,
                    trackName = "Track $i",
                    artistName = "Artist Name",
                    duration = "3:30"
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun EmptyDetailContent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Select a playlist to view details",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun PlaylistItem(
    playlist: Playlist,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            // Playlist icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = playlist.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                Text(
                    text = "${playlist.trackCount} songs",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun TrackItem(
    trackNumber: Int,
    trackName: String,
    artistName: String,
    duration: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = trackNumber.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(32.dp)
        )
        
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = trackName,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            Text(
                text = artistName,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        Text(
            text = duration,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * Data class representing a playlist
 */
data class Playlist(
    val id: String,
    val name: String,
    val description: String,
    val trackCount: Int
)
