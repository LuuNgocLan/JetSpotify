package com.jetspotify.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumsData(
    val albums: List<Album>
)

@Serializable
data class Album(
    @SerialName("album_type") val albumType: String? = null,
    @SerialName("total_tracks") val totalTracks: Long? = null,
    @SerialName("available_markets") val availableMarkets: List<String>? = null,
    @SerialName("external_urls") val externalUrls: ExternalUrls? = null,
    val href: String? = null,
    val id: String? = null,
    val images: String? = null,
    val name: String? = null,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("release_date_precision") val releaseDatePrecision: String? = null,
    val restrictions: Restrictions? = null,
    val type: String? = null,
    val uri: String? = null,
    val artists: List<Artist>? = null,
    val tracks: Tracks? = null,
    val copyrights: List<Copyright>? = null,
    @SerialName("external_ids") val externalIds: ExternalIds? = null,
    val genres: List<String>? = null,
    val label: String? = null,
    val popularity: Long? = null
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