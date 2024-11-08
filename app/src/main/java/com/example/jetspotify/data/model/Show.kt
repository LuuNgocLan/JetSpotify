package com.example.jetspotify.data.model

data class Show(
    val id: String,
    val showName: String,
    val category: List<String>,
    val showType: String,
    val thumbnail: String,
    val description: String,
)