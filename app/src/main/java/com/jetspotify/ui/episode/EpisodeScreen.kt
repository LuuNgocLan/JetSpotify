package com.jetspotify.ui.episode

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.jetspotify.R
import com.jetspotify.model.Episode


@Composable
fun EpisodeDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = viewModel(factory = EpisodeViewModel.provideFactory()),

    ) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1C1B1F))
    ) {
        EpisodeDetailContent(
            episode = viewModel.uiState.collectAsState().value.episodes.first(),
            onBackClick = { },
            onPlayClick = { },
            onAddClick = { },
            onDownloadClick = { },
            onShareClick = {},
            onMoreClick = {}
        )

    }
}

@Composable
private fun EpisodeDetailContent(
    episode: Episode,
    onBackClick: () -> Unit,
    onPlayClick: () -> Unit,
    onAddClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onShareClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        // Top Bar with back button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        // Episode Thumbnail
        AsyncImage(
            model = episode.thumbnailUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            contentScale = ContentScale.Crop
        )

        // Episode Info
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = episode.title,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_spotify_mini),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = episode.showName,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${episode.publishDate} • ${episode.duration}",
                color = Color.White.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val buttonModifier = Modifier.size(48.dp)
                AsyncImage(
                    modifier = Modifier
                        .size(width = 36.dp, height = 48.dp)
                        .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.onSecondary, RoundedCornerShape(4.dp)
                        )
                        .background(color = Color.Gray.copy(alpha = 0.5f)),
                    model = episode.thumbnailUrl,
                    contentDescription = "Episode",
                    contentScale = ContentScale.Crop,
                )
                IconButton(onClick = onAddClick, modifier = buttonModifier) {
                    Icon(
                        Icons.Default.AddCircleOutline,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
                IconButton(onClick = onDownloadClick, modifier = buttonModifier) {
                    Icon(
                        painter =
                        painterResource(id = R.drawable.ic_download),
                        contentDescription = "Download",
                        tint = Color.White
                    )
                }
                IconButton(onClick = onShareClick, modifier = buttonModifier) {
                    Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.White)
                }
                IconButton(onClick = onMoreClick, modifier = buttonModifier) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = onPlayClick,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play_color),
                        contentDescription = "Play",
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Description
            Text(
                text = episode.description,
                color = Color.White.copy(alpha = 0.9f),
                lineHeight = 24.sp
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun EpisodeDetailScreenPreview() {
    EpisodeDetailScreen()
}
