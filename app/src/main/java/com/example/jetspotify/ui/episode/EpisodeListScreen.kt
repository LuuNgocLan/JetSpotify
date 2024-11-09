package com.example.jetspotify.ui.episode

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.jetspotify.R
import com.example.jetspotify.model.Episode
import com.example.jetspotify.ui.navigation.JetSpotifyNavController
import com.example.jetspotify.ui.navigation.rememberJetSpotifyNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodesScreen(
    modifier: Modifier = Modifier,
) {
    val _uiState = remember { mutableStateOf<EpisodeUiState?>(null) }
    val uiState = _uiState.value
    val navController: JetSpotifyNavController = rememberJetSpotifyNavController()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        // Top App Bar
        TopAppBar(
            colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = Color.White,
            ),
            title = {
                Text(
                    text = "TED Talks Daily",
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
        )

        // Tab Row
//        TabRow(
//            selectedTabIndex = 0,
//            indicator = { tabPositions ->
//                TabRowDefaults.SecondaryIndicator(
//                    height = 2.dp
//                )
//            }
//        ) {
//            Tab(
//                selected = state.selectedTab == 0,
//                onClick = { onTabSelected(0) },
//                text = { Text("Episodes", color = Color.White) }
//            )
//            Tab(
//                selected = state.selectedTab == 1,
//                onClick = { onTabSelected(1) },
//                text = { Text("About", color = Color.White) }
//            )
//            Tab(
//                selected = state.selectedTab == 2,
//                onClick = { onTabSelected(2) },
//                text = { Text("More like this", color = Color.White) }
//            )
//        }

        // Sort Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Sort,
                contentDescription = "Sort",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "All episodes • Newest",
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }


        LazyColumn {
            items(uiState?.episodes ?: emptyList()) { episode ->
                EpisodeItem(
                    episode = episode,
                    onClick = {
                    },
                    onPlayClick = { },
                    onAddClick = { },
                    onDownloadClick = { },
                    onShareClick = { },
                    onMoreClick = { }
                )
            }
        }

    }
}

@Composable
private fun EpisodeItem(
    episode: Episode,
    onClick: () -> Unit,
    onPlayClick: () -> Unit,
    onAddClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onShareClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Thumbnail
            AsyncImage(
                model = episode.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            // Episode Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = "${episode.title} | ${episode.speaker}",
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = episode.description,
                    color = Color.White.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${episode.publishDate} • ${episode.duration}",
                    color = Color.White.copy(alpha = 0.5f)
                )
            }

            // Play Button
            IconButton(
                onClick = onPlayClick,
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_white),
                    contentDescription = "Play",
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Action Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (episode.isDownloaded) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Downloaded",
                    tint = Color(0xFF1DB954),
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = "Download",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))

            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            IconButton(onClick = onMoreClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }

        Divider(
            color = Color.White.copy(alpha = 0.1f),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewEpisodesScreen() {
    EpisodesScreen(
    )
}

