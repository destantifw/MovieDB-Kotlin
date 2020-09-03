package com.destanti.MovieDB.data.Model


import kotlinx.serialization.*


@Serializable
data class ReviewModel (
    val id: Long,
    val page: Long,
    val results: List<ReviewResult>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)

@Serializable
data class ReviewResult (
    val id: String,
    val author: String,
    val content: String,
    val url: String
)
