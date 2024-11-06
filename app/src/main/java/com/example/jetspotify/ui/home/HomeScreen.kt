package com.example.jetspotify.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.jetspotify.components.HomeTopBar
import com.example.jetspotify.data.model.Category
import com.example.jetspotify.data.model.LocalDataProvider
import com.example.jetspotify.ui.utils.JetSpotifyNavigationType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navigationType: JetSpotifyNavigationType,) {
    val context = LocalContext.current
    val albums = LocalDataProvider.loadCategories(context)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 80.dp) // For bottom navigation
    ) {
        // Sticky header
        stickyHeader {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.background
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
                items(albums.take(8)) { category ->
                    CategoryItem(
                        category = category,
                        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Jump back in section
        item {
            Text(
                text = "Jump back in",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
        }

        item {
            // Horizontal scrolling albums
            LazyRow(
                modifier = Modifier.padding(start = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(albums) { category ->
                    AlbumItem(
                        category = category,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Your top mixes section
        item {
            Text(
                text = "Your top mixes",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
        }

        item {
            LazyRow(
                modifier = Modifier.padding(start = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(albums) { category ->
                    AlbumItem(
                        category = category,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Your top mixes section
        item {
            Text(
                text = "Recents",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
        }

        item {
            LazyRow(
                modifier = Modifier.padding(start = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(albums) { category ->
                    AlbumItem(
                        category = category,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
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
                .height(58.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = Color.Gray.copy(alpha = 0.5f)),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                    .background(color = Color.Gray.copy(alpha = 0.5f)),
                model = category.icons.first().url ?: "",
                contentDescription = "Category",
//                placeholder = painterResource(R.drawable.ic_menu_camera),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = category.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


@Composable
fun AlbumItem(category: Category, modifier: Modifier = Modifier) {
    Box {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .width(154.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(154.dp)
                    .background(color = Color.Gray.copy(alpha = 0.5f)),
                model = category.icons.first().url ?: "",
                contentDescription = "Album",
//                placeholder = painterResource(drawable.ic_menu_camera),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}