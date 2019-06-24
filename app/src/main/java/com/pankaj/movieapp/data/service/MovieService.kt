package com.pankaj.movieapp.data.service

import com.pankaj.movieapp.data.RetrofitLiveData
import com.pankaj.movieapp.data.model.Movies
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("{path1}/raw/{path2}/movies.json")
    fun getMovies(@Path("path1") path1: String, @Path("path2") path2: String): RetrofitLiveData<Movies>

}