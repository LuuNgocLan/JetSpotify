package com.example.jetspotify.ui.navigation

/**
 * Navigation routes for the JetSpotify app
 */
sealed class JetSpotifyRoute(val route: String) {
    // Main tab routes
    object Home : JetSpotifyRoute("home")
    object Search : JetSpotifyRoute("search")
    object Library : JetSpotifyRoute("library")
    object Premium : JetSpotifyRoute("premium")
    
    // Detail routes
    object PlaylistDetail : JetSpotifyRoute("playlist/{playlistId}") {
        fun createRoute(playlistId: String) = "playlist/$playlistId"
    }
}
