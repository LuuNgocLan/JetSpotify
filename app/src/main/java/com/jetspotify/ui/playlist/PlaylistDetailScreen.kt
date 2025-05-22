package com.jetspotify.ui.playlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.jetspotify.data.model.Playlist
import com.jetspotify.data.model.Song
import com.jetspotify.ui.theme.SpotifyPalette
import com.jetspotify.ui.theme.SpotifyGradients

/**
 * Main screen for displaying a playlist's details
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistDetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PlaylistViewModel = viewModel()
) {
    val playlistState by viewModel.playlistState.collectAsState()
    
    playlistState?.let { playlist ->
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        navigationIconContentColor = Color.White
                    )
                )
            },
            containerColor = SpotifyPalette.black
        ) { paddingValues ->
            PlaylistContent(
                playlist = playlist,
                modifier = Modifier.padding(paddingValues)
            )
        }
    } ?: Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SpotifyPalette.black),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = SpotifyPalette.green)
    }
}

/**
 * Content section of the playlist detail screen
 */
@Composable
private fun PlaylistContent(
    playlist: Playlist,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = SpotifyGradients.playlistHeaderGradient
                )
            )
    ) {
        // Playlist header
        item {
            PlaylistHeader(
                playlist = playlist,
                onPlayClick = { /* Play the playlist */ }
            )
        }
        
        // Action buttons
        item {
            PlaylistActions()
        }
        
        // Song list
        items(playlist.songs) { song ->
            SongItem(
                song = song,
                onSongClick = { /* Play the song */ },
                onMoreClick = { /* Show options */ },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        // Bottom spacing
        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

/**
 * Header section of the playlist showing cover art and details
 */
@Composable
fun PlaylistHeader(
    playlist: Playlist,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Playlist cover
        AsyncImage(
            model = playlist.coverUrl,
            contentDescription = "${playlist.title} cover",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Playlist title
        Text(
            text = playlist.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Playlist description
        Text(
            text = playlist.description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.8f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Creator info
        Text(
            text = playlist.creator,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f)
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Stats (followers and duration)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${formatNumber(playlist.followers)} lượt lưu",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.6f)
            )
            
            Text(
                text = " • ",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.6f)
            )
            
            Text(
                text = playlist.duration,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.6f)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Play button
        FloatingActionButton(
            onClick = onPlayClick,
            containerColor = SpotifyPalette.green,
            contentColor = Color.Black,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

/**
 * Action buttons for the playlist (shuffle, download, etc.)
 */
@Composable
private fun PlaylistActions(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left side actions
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Add to library */ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add to library",
                    tint = Color.White.copy(alpha = 0.7f)
                )
            }
            
            IconButton(onClick = { /* Download playlist */ }) {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Download",
                    tint = Color.White.copy(alpha = 0.7f)
                )
            }
            
            IconButton(onClick = { /* More options */ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                    tint = Color.White.copy(alpha = 0.7f)
                )
            }
        }
        
        // Play button
        FloatingActionButton(
            onClick = { /* Play playlist */ },
            containerColor = SpotifyPalette.green,
            contentColor = Color.Black,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

/**
 * Format large numbers with comma separators
 */
private fun formatNumber(number: Int): String {
    return String.format("%,d", number)
}
