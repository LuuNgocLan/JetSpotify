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

/**
 * Spotify brand color palette
 */
object SpotifyPalette {
    // Base brand colors
    val green = Color(0xFF1DB954)
    val black = Color(0xFF191414)
    val darkGrey = Color(0xFF282828)
    val lightGrey = Color(0xFF535353)
    val white = Color(0xFFFFFFFF)
    
    // Additional UI colors
    val error = Color(0xFFE91429)
    val deepBlack = Color(0xFF121212)
}

/**
 * Spotify theme colors organized by Material 3 color roles
 */
object SpotifyTheme {
    /**
     * Light theme color definitions
     */
    object Light {
        // Primary
        val primary = SpotifyPalette.green
        val onPrimary = Color.Black
        val primaryContainer = SpotifyPalette.green.copy(alpha = 0.9f)
        val onPrimaryContainer = Color.Black
        
        // Secondary
        val secondary = SpotifyPalette.darkGrey
        val onSecondary = SpotifyPalette.white
        val secondaryContainer = SpotifyPalette.lightGrey
        val onSecondaryContainer = SpotifyPalette.white
        
        // Tertiary
        val tertiary = SpotifyPalette.deepBlack
        val onTertiary = SpotifyPalette.white
        val tertiaryContainer = Color(0xFF404040)
        val onTertiaryContainer = SpotifyPalette.white
        
        // Error
        val error = SpotifyPalette.error
        val onError = SpotifyPalette.white
        val errorContainer = Color(0xFFFFDAD6)
        val onErrorContainer = Color(0xFF410002)
        
        // Background
        val background = SpotifyPalette.white
        val onBackground = SpotifyPalette.black
        val surface = Color(0xFFF0F0F0)
        val onSurface = SpotifyPalette.black
        val surfaceVariant = Color(0xFFE5E5E5)
        val onSurfaceVariant = SpotifyPalette.black
        
        // Other
        val outline = SpotifyPalette.lightGrey
        val outlineVariant = Color(0xFFBFC8CB)
        val scrim = Color(0xFF000000)
    }
    
    /**
     * Dark theme color definitions (Spotify's primary theme)
     */
    object Dark {
        // Primary
        val primary = SpotifyPalette.green
        val onPrimary = Color.Black
        val primaryContainer = SpotifyPalette.green.copy(alpha = 0.9f)
        val onPrimaryContainer = Color.Black
        
        // Secondary
        val secondary = Color(0xFF535353)
        val onSecondary = SpotifyPalette.white
        val secondaryContainer = SpotifyPalette.darkGrey
        val onSecondaryContainer = SpotifyPalette.white
        
        // Tertiary
        val tertiary = SpotifyPalette.deepBlack
        val onTertiary = SpotifyPalette.white
        val tertiaryContainer = Color(0xFF404040)
        val onTertiaryContainer = SpotifyPalette.white
        
        // Error
        val error = SpotifyPalette.error
        val onError = SpotifyPalette.white
        val errorContainer = Color(0xFF93000A)
        val onErrorContainer = Color(0xFFFFDAD6)
        
        // Background
        val background = SpotifyPalette.black
        val onBackground = SpotifyPalette.white
        val surface = SpotifyPalette.darkGrey
        val onSurface = SpotifyPalette.white
        val surfaceVariant = Color(0xFF404040)
        val onSurfaceVariant = SpotifyPalette.white
        
        // Other
        val outline = SpotifyPalette.lightGrey
        val outlineVariant = Color(0xFF3F484B)
        val scrim = Color(0xFF000000)
    }
}

/**
 * Gradients used in Spotify UI
 */
object SpotifyGradients {
    val darkGradientBackground = listOf(
        SpotifyPalette.deepBlack,
        SpotifyPalette.deepBlack.copy(alpha = 0.8f),
        SpotifyPalette.deepBlack.copy(alpha = 0.6f)
    )

    val playlistHeaderGradient = listOf(
        Color(0xFF464646),
        SpotifyPalette.black
    )

    val playerGradient = listOf(
        SpotifyPalette.black.copy(alpha = 0.8f),
        SpotifyPalette.black
    )
}

/**
 * Creates the dark color scheme for Spotify theme
 */
fun spotifyDarkColorScheme() = darkColorScheme(
    primary = SpotifyTheme.Dark.primary,
    onPrimary = SpotifyTheme.Dark.onPrimary,
    primaryContainer = SpotifyTheme.Dark.primaryContainer,
    onPrimaryContainer = SpotifyTheme.Dark.onPrimaryContainer,
    secondary = SpotifyTheme.Dark.secondary,
    onSecondary = SpotifyTheme.Dark.onSecondary,
    secondaryContainer = SpotifyTheme.Dark.secondaryContainer,
    onSecondaryContainer = SpotifyTheme.Dark.onSecondaryContainer,
    tertiary = SpotifyTheme.Dark.tertiary,
    onTertiary = SpotifyTheme.Dark.onTertiary,
    tertiaryContainer = SpotifyTheme.Dark.tertiaryContainer,
    onTertiaryContainer = SpotifyTheme.Dark.onTertiaryContainer,
    error = SpotifyTheme.Dark.error,
    onError = SpotifyTheme.Dark.onError,
    errorContainer = SpotifyTheme.Dark.errorContainer,
    onErrorContainer = SpotifyTheme.Dark.onErrorContainer,
    background = SpotifyTheme.Dark.background,
    onBackground = SpotifyTheme.Dark.onBackground,
    surface = SpotifyTheme.Dark.surface,
    onSurface = SpotifyTheme.Dark.onSurface,
    surfaceVariant = SpotifyTheme.Dark.surfaceVariant,
    onSurfaceVariant = SpotifyTheme.Dark.onSurfaceVariant,
    outline = SpotifyTheme.Dark.outline,
    outlineVariant = SpotifyTheme.Dark.outlineVariant,
    scrim = SpotifyTheme.Dark.scrim,
)

/**
 * Creates the light color scheme for Spotify theme
 */
fun spotifyLightColorScheme() = lightColorScheme(
    primary = SpotifyTheme.Light.primary,
    onPrimary = SpotifyTheme.Light.onPrimary,
    primaryContainer = SpotifyTheme.Light.primaryContainer,
    onPrimaryContainer = SpotifyTheme.Light.onPrimaryContainer,
    secondary = SpotifyTheme.Light.secondary,
    onSecondary = SpotifyTheme.Light.onSecondary,
    secondaryContainer = SpotifyTheme.Light.secondaryContainer,
    onSecondaryContainer = SpotifyTheme.Light.onSecondaryContainer,
    tertiary = SpotifyTheme.Light.tertiary,
    onTertiary = SpotifyTheme.Light.onTertiary,
    tertiaryContainer = SpotifyTheme.Light.tertiaryContainer,
    onTertiaryContainer = SpotifyTheme.Light.onTertiaryContainer,
    error = SpotifyTheme.Light.error,
    onError = SpotifyTheme.Light.onError,
    errorContainer = SpotifyTheme.Light.errorContainer,
    onErrorContainer = SpotifyTheme.Light.onErrorContainer,
    background = SpotifyTheme.Light.background,
    onBackground = SpotifyTheme.Light.onBackground,
    surface = SpotifyTheme.Light.surface,
    onSurface = SpotifyTheme.Light.onSurface,
    surfaceVariant = SpotifyTheme.Light.surfaceVariant,
    onSurfaceVariant = SpotifyTheme.Light.onSurfaceVariant,
    outline = SpotifyTheme.Light.outline,
    outlineVariant = SpotifyTheme.Light.outlineVariant,
    scrim = SpotifyTheme.Light.scrim,
)