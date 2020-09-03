package com.destanti.MovieDB.data.Model


import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

@Serializable
data class MovieList (
    val page: Int,
    val results: List<MovieListResult>,

    @SerialName("total_results")
    val totalResults: Int,

    @SerialName("total_pages")
    val totalPages: Int
)

@Serializable
data class MovieListResult (
    @SerialName("poster_path")
    val posterPath: String,

    val adult: Boolean,
    val overview: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("genre_ids")
    val genreIDS: List<Long>,

    val id: Int,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("original_language")
    val originalLanguage: String,

    val title: String,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    val popularity: Double,

    @SerialName("vote_count")
    val voteCount: Int,

    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double
)