package com.jetspotify.data.repository

import com.jetspotify.data.model.Playlist
import com.jetspotify.data.model.Song

/**
 * Repository providing playlist data
 */
object PlaylistRepository {
    
    /**
     * Get a sample Imagine Dragons playlist
     */
    fun getImaginePlaylist(): Playlist {
        return Playlist(
            id = "1",
            title = "Best of Imagine Dragons",
            description = "Every song is awesome, but here are the best ones",
            coverUrl = "https://i.scdn.co/image/ab67616d0000b273b2b2747c89d2157b0b29fb6a",
            creator = "Patrik Ševčík và 1 người khác",
            followers = 179755,
            duration = "3 giờ 58 phút",
            songs = listOf(
                Song(
                    id = "1",
                    title = "Believer",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273b2b2747c89d2157b0b29fb6a",
                    duration = "3:24"
                ),
                Song(
                    id = "2",
                    title = "Bones",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273c3af0c2355c24ed7023cd394",
                    duration = "2:45"
                ),
                Song(
                    id = "3",
                    title = "Radioactive",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b2735eab23d2260268d2fab870d0",
                    duration = "3:07"
                ),
                Song(
                    id = "4",
                    title = "Thunder",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273b2b2747c89d2157b0b29fb6a",
                    duration = "3:07"
                ),
                Song(
                    id = "5",
                    title = "Demons",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273b2b2747c89d2157b0b29fb6a",
                    duration = "2:57"
                ),
                Song(
                    id = "6",
                    title = "Natural",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273da6f73a25f4c79d0e6b4a8bd",
                    duration = "3:09"
                ),
                Song(
                    id = "7",
                    title = "Wrecked",
                    artist = "Imagine Dragons",
                    albumCoverUrl = "https://i.scdn.co/image/ab67616d0000b273a7e3aee4b0b9e9f5b7eac5ee",
                    duration = "3:54"
                )
            )
        )
    }
}
