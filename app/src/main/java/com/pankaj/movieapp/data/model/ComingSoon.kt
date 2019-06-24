package com.pankaj.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class ComingSoon(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("averageRating") val averageRating: String,
    @SerializedName("storyline") val storyline: String,
    @SerializedName("actors") val actors: List<String>,
    @SerializedName("posterurl") val posterUrl: String
)
