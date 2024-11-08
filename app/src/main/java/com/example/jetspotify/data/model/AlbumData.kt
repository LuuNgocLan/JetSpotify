package com.example.jetspotify.model

import com.example.jetspotify.data.model.Image
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumsData(
    val albums: List<Album>
)

@Serializable
data class Album(
    @SerialName("album_type") val albumType: String,
    @SerialName("total_tracks") val totalTracks: Long,
    @SerialName("available_markets") val availableMarkets: List<String>,
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("release_date_precision") val releaseDatePrecision: String,
    val restrictions: Restrictions,
    val type: String,
    val uri: String, val artists: List<Artist>,
    val tracks: Tracks,
    val copyrights: List<Copyright>,
    @SerialName("external_ids") val externalIds: ExternalIds,
    val genres: List<String>,
    val label: String,
    val popularity: Long
)

@Serializable
data class Artist(
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)

@Serializable
data class ExternalUrls(
    val spotify: String
)

@Serializable
data class Copyright(
    val text: String,
    val type: String
)

@Serializable
data class ExternalIds(
    val isrc: String,
    val ean: String,
    val upc: String
)

@Serializable
data class Restrictions(
    val reason: String
)

@Serializable
data class Item(
    val artists: List<Artist>,
    @SerialName("available_markets") val availableMarkets: List<String>,
    @SerialName("disc_number") val discNumber: Long,
    @SerialName("duration_ms") val durationMs: Long,
    val explicit: Boolean,
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    @SerialName("is_playable") val isPlayable: Boolean,
    @SerialName("linked_from") val linkedFrom: LinkedFrom,
    val restrictions: Restrictions,
    val name: String,
    @SerialName("preview_url") val previewUrl: String,
    @SerialName("track_number") val trackNumber: Long,
    val type: String,
    val uri: String,
    @SerialName("is_local") val isLocal: Boolean
)

@Serializable
data class LinkedFrom(
    @SerialName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val type: String,
    val uri: String
)