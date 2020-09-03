package com.destanti.MovieDB.data.Model


import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

@Serializable
data class VideoDetail (
    val id: Long,
    val results: List<Result>
)

@Serializable
data class Result (
    val id: String,

    @SerialName("iso_639_1")
    val iso639_1: String,

    @SerialName("iso_3166_1")
    val iso3166_1: String,

    val key: String,
    val name: String,
    val site: String,
    val size: Long,
    val type: String
)
