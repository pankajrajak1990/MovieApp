package com.pankaj.movieapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pankaj.movieapp.data.DataHandler
import com.pankaj.movieapp.data.RetrofitLiveData
import com.pankaj.movieapp.data.model.ApiResponse
import com.pankaj.movieapp.data.model.Movies

class ComingSoonViewModel(app: Application) : AndroidViewModel(app) {



    val path1 = "df5c94f75f64fc9af0c8b87e431011bb"
    val path2 = "ee22cb6b0a76b0cc06e57d77b47fb7234e12fc90"



    fun getMovies(): RetrofitLiveData<Movies> {
        return DataHandler.INSTANCE.moviesRepository.getMovies(path1, path2)
    }


}
