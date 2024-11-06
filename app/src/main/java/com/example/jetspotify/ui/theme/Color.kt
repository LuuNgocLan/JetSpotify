/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetspotify.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Common colors used in both themes
object SpotifyColors {
    val SpotifyGreen = Color(0xFF1DB954)
    val SpotifyBlack = Color(0xFF191414)
    val SpotifyDarkGrey = Color(0xFF282828)
    val SpotifyLightGrey = Color(0xFF535353)
    val SpotifyWhite = Color(0xFFFFFFFF)
}
// Light Theme Colors
val spotify_theme_light_primary = SpotifyColors.SpotifyGreen
val spotify_theme_light_onPrimary = Color.Black
val spotify_theme_light_primaryContainer = SpotifyColors.SpotifyGreen.copy(alpha = 0.9f)
val spotify_theme_light_onPrimaryContainer = Color.Black

val spotify_theme_light_secondary = SpotifyColors.SpotifyDarkGrey
val spotify_theme_light_onSecondary = SpotifyColors.SpotifyWhite
val spotify_theme_light_secondaryContainer = SpotifyColors.SpotifyLightGrey
val spotify_theme_light_onSecondaryContainer = SpotifyColors.SpotifyWhite

val spotify_theme_light_tertiary = Color(0xFF121212)
val spotify_theme_light_onTertiary = SpotifyColors.SpotifyWhite
val spotify_theme_light_tertiaryContainer = Color(0xFF404040)
val spotify_theme_light_onTertiaryContainer = SpotifyColors.SpotifyWhite

val spotify_theme_light_error = Color(0xFFE91429)
val spotify_theme_light_onError = SpotifyColors.SpotifyWhite
val spotify_theme_light_errorContainer = Color(0xFFFFDAD6)
val spotify_theme_light_onErrorContainer = Color(0xFF410002)

val spotify_theme_light_background = SpotifyColors.SpotifyWhite
val spotify_theme_light_onBackground = SpotifyColors.SpotifyBlack
val spotify_theme_light_surface = Color(0xFFF0F0F0)
val spotify_theme_light_onSurface = SpotifyColors.SpotifyBlack
val spotify_theme_light_surfaceVariant = Color(0xFFE5E5E5)
val spotify_theme_light_onSurfaceVariant = SpotifyColors.SpotifyBlack

val spotify_theme_light_outline = SpotifyColors.SpotifyLightGrey
val spotify_theme_light_outlineVariant = Color(0xFFBFC8CB)
val spotify_theme_light_scrim = Color(0xFF000000)

// Dark Theme Colors (Spotify's primary theme)
val spotify_theme_dark_primary = SpotifyColors.SpotifyGreen
val spotify_theme_dark_onPrimary = Color.Black
val spotify_theme_dark_primaryContainer = SpotifyColors.SpotifyGreen.copy(alpha = 0.9f)
val spotify_theme_dark_onPrimaryContainer = Color.Black

val spotify_theme_dark_secondary = Color(0xFF535353)
val spotify_theme_dark_onSecondary = SpotifyColors.SpotifyWhite
val spotify_theme_dark_secondaryContainer = SpotifyColors.SpotifyDarkGrey
val spotify_theme_dark_onSecondaryContainer = SpotifyColors.SpotifyWhite

val spotify_theme_dark_tertiary = Color(0xFF121212)
val spotify_theme_dark_onTertiary = SpotifyColors.SpotifyWhite
val spotify_theme_dark_tertiaryContainer = Color(0xFF404040)
val spotify_theme_dark_onTertiaryContainer = SpotifyColors.SpotifyWhite

val spotify_theme_dark_error = Color(0xFFE91429)
val spotify_theme_dark_onError = SpotifyColors.SpotifyWhite
val spotify_theme_dark_errorContainer = Color(0xFF93000A)
val spotify_theme_dark_onErrorContainer = Color(0xFFFFDAD6)

val spotify_theme_dark_background = SpotifyColors.SpotifyBlack
val spotify_theme_dark_onBackground = SpotifyColors.SpotifyWhite
val spotify_theme_dark_surface = SpotifyColors.SpotifyDarkGrey
val spotify_theme_dark_onSurface = SpotifyColors.SpotifyWhite
val spotify_theme_dark_surfaceVariant = Color(0xFF404040)
val spotify_theme_dark_onSurfaceVariant = SpotifyColors.SpotifyWhite

val spotify_theme_dark_outline = SpotifyColors.SpotifyLightGrey
val spotify_theme_dark_outlineVariant = Color(0xFF3F484B)
val spotify_theme_dark_scrim = Color(0xFF000000)

// Gradients
object SpotifyGradients {
    val darkGradientBackground = listOf(
        Color(0xFF121212),
        Color(0xFF121212).copy(alpha = 0.8f),
        Color(0xFF121212).copy(alpha = 0.6f)
    )

    val playlistHeaderGradient = listOf(
        Color(0xFF464646),
        SpotifyColors.SpotifyBlack
    )

    val playerGradient = listOf(
        SpotifyColors.SpotifyBlack.copy(alpha = 0.8f),
        SpotifyColors.SpotifyBlack
    )
}

// Use this to create the ColorScheme
fun spotifyDarkColorScheme() = darkColorScheme(
    primary = spotify_theme_dark_primary,
    onPrimary = spotify_theme_dark_onPrimary,
    primaryContainer = spotify_theme_dark_primaryContainer,
    onPrimaryContainer = spotify_theme_dark_onPrimaryContainer,
    secondary = spotify_theme_dark_secondary,
    onSecondary = spotify_theme_dark_onSecondary,
    secondaryContainer = spotify_theme_dark_secondaryContainer,
    onSecondaryContainer = spotify_theme_dark_onSecondaryContainer,
    tertiary = spotify_theme_dark_tertiary,
    onTertiary = spotify_theme_dark_onTertiary,
    tertiaryContainer = spotify_theme_dark_tertiaryContainer,
    onTertiaryContainer = spotify_theme_dark_onTertiaryContainer,
    error = spotify_theme_dark_error,
    onError = spotify_theme_dark_onError,
    errorContainer = spotify_theme_dark_errorContainer,
    onErrorContainer = spotify_theme_dark_onErrorContainer,
    background = spotify_theme_dark_background,
    onBackground = spotify_theme_dark_onBackground,
    surface = spotify_theme_dark_surface,
    onSurface = spotify_theme_dark_onSurface,
    surfaceVariant = spotify_theme_dark_surfaceVariant,
    onSurfaceVariant = spotify_theme_dark_onSurfaceVariant,
    outline = spotify_theme_dark_outline,
    outlineVariant = spotify_theme_dark_outlineVariant,
    scrim = spotify_theme_dark_scrim,
)

fun spotifyLightColorScheme() = lightColorScheme(
    primary = spotify_theme_light_primary,
    onPrimary = spotify_theme_light_onPrimary,
    primaryContainer = spotify_theme_light_primaryContainer,
    onPrimaryContainer = spotify_theme_light_onPrimaryContainer,
    secondary = spotify_theme_light_secondary,
    onSecondary = spotify_theme_light_onSecondary,
    secondaryContainer = spotify_theme_light_secondaryContainer,
    onSecondaryContainer = spotify_theme_light_onSecondaryContainer,
    tertiary = spotify_theme_light_tertiary,
    onTertiary = spotify_theme_light_onTertiary,
    tertiaryContainer = spotify_theme_light_tertiaryContainer,
    onTertiaryContainer = spotify_theme_light_onTertiaryContainer,
    error = spotify_theme_light_error,
    onError = spotify_theme_light_onError,
    errorContainer = spotify_theme_light_errorContainer,
    onErrorContainer = spotify_theme_light_onErrorContainer,
    background = spotify_theme_light_background,
    onBackground = spotify_theme_light_onBackground,
    surface = spotify_theme_light_surface,
    onSurface = spotify_theme_light_onSurface,
    surfaceVariant = spotify_theme_light_surfaceVariant,
    onSurfaceVariant = spotify_theme_light_onSurfaceVariant,
    outline = spotify_theme_light_outline,
    outlineVariant = spotify_theme_light_outlineVariant,
    scrim = spotify_theme_light_scrim,
)