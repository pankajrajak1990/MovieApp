package com.pankaj.movieapp.data.model

import com.google.gson.annotations.SerializedName


data class Movies(
    @SerializedName("comingsoon") val comingSoon: List<ComingSoon>,
    @SerializedName("movieintheaters") val movieInTheatre: List<MovieInTheatres>?,
    @SerializedName("indianmovies") val indianMoviesm: List<IndianMovies>?
)
