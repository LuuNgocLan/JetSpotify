package com.example.jetspotify.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.jetspotify.R
import com.example.jetspotify.components.HomeTopBar
import com.example.jetspotify.data.model.Category
import com.example.jetspotify.data.model.LocalDataProvider
import com.example.jetspotify.data.model.Show
import com.example.jetspotify.model.Album

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.provideFactory()),
) {
    val context = LocalContext.current
    val _uiState = remember { mutableStateOf<HomeUiState?>(null) }
    val uiState = _uiState.value

    // Load data once when the composable enters the composition
    LaunchedEffect(Unit) {
        val categories = LocalDataProvider.loadCategories(context = context)
        val albums = LocalDataProvider.loadAlbums()
        val shows = LocalDataProvider.sampleShowsData()
        _uiState.value = uiState?.copy(
            categories = categories, albums = albums, shows = shows
        ) ?: HomeUiState(
            categories = categories, albums = albums, shows = shows
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 80.dp) // For bottom navigation
    ) {
        // Sticky header
        stickyHeader {
            Surface(
                modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    HomeTopBar()
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(4.dp))
        }

        // Categories Grid
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(((58 + 8) * 2).dp), // Fixed height based on number of rows
                userScrollEnabled = false // Disable grid scrolling
            ) {

                items(uiState?.categories?.take(8) ?: emptyList()) { category ->
                    CategoryItem(
                        category = category, modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }

        // Shows
        item {
            Text(
                text = "Your shows", style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White, fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
        }

        item {
            LazyRow(
                modifier = Modifier.padding(start = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(uiState?.shows ?: emptyList()) { show ->
                    ShowItem(
                        show = show, modifier = Modifier.padding(end = 8.dp)
                    ) {
                        /* Handle on item click */
                    }
                }
            }
        }

        // Your top mixes section
        item {
            Text(
                text = "Your top mixes", style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White, fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(16.dp)
            )
        }

        item {
            LazyRow(
                modifier = Modifier.padding(start = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(uiState?.albums ?: emptyList()) { album ->
                    AlbumItem(
                        album = album, modifier = Modifier.padding(end = 8.dp)
                    ) {
                        /* Handle on item click */
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.category_thumbnail_size))
                .clip(RoundedCornerShape(4.dp))
                .background(color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f)),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.category_thumbnail_size))
                    .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                    .background(color = Color.Gray.copy(alpha = 0.5f)),
                model = category.icons.first().url ?: "",
                contentDescription = "Category",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = category.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


@Composable
fun AlbumItem(album: Album, modifier: Modifier = Modifier, onItemEpisodeClick: (String) -> Unit) {
    Box(
        modifier = modifier.clickable(
            onClick = {
                /*Handle click on item */
            },
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.width(dimensionResource(id = R.dimen.album_thumbnail_size))
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.album_thumbnail_size))
                    .background(color = Color.Gray.copy(alpha = 0.5f)),
                model = album.images ?: "",
                contentDescription = "Album",
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = album.name ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = album.artists?.map { it.name }?.joinToString("-") ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}


@Composable
fun ShowItem(show: Show, modifier: Modifier = Modifier, onItemEpisodeClick: (String) -> Unit) {
    Box(modifier = modifier.clickable(onClick = {
        onItemEpisodeClick(show.id)
    })) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.width(dimensionResource(id = R.dimen.album_thumbnail_size))
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.album_thumbnail_size))
                    .background(color = Color.Gray.copy(alpha = 0.5f))
                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)),
                model = show.thumbnail,
                contentDescription = show.showName,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = show.category.map { it }.joinToString("-"),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = show.showName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Medium
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Show-${show.showType}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray, fontSize = 11.sp, fontWeight = FontWeight.Medium
                ),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}