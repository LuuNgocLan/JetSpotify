package com.jetspotify.data.model

import com.jetspotify.model.Tracks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistData(
    val href: String,
    val limit: Long,
    val next: String,
    val offset: Long,
    val previous: String,
    val total: Long,
    val items: List<SpotifyPlaylist>
)

@Serializable
data class SpotifyPlaylist(
    val collaborative: Boolean,
    val description: String,
    @SerialName("external_urls") val externalUrls: ItemExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>? = null,
    val name: String,
    val owner: Owner,
    val public: Boolean,
    @SerialName("snapshot_id") val snapshotId: String,
    val tracks: Tracks,
    val type: String,
    val uri: String
)

@Serializable
data class ItemExternalUrls(
    val spotify: String
)

@Serializable
data class Owner(
    @SerialName("display_name") val displayName: String,
    @SerialName("external_urls") val externalUrls: OwnerExternalUrls,
    val href: String,
    val id: String,
    val type: String,
    val uri: String
)

@Serializable
data class OwnerExternalUrls(
    val spotify: String
)