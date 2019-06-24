package com.pankaj.movieapp.data.repository

import com.pankaj.movieapp.data.RetrofitLiveData
import com.pankaj.movieapp.data.model.Movies
import com.pankaj.movieapp.data.service.MovieService

class MoviesRepository(val movieService: MovieService) {

    fun getMovies(path1: String, path2: String): RetrofitLiveData<Movies> = movieService.getMovies(path1, path2)


}