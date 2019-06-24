package com.pankaj.movieapp.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.pankaj.movieapp.data.repository.MoviesRepository
import com.pankaj.movieapp.data.service.MovieService
import com.pankaj.movieapp.data.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class DataHandler private constructor() {

    companion object Singleton {
        val INSTANCE: DataHandler by lazy { DataHandler() }

        const val BASE_URL2 = "https://gist.githubusercontent.com/SkyTreasure/"
//        const val BASE_URL2 = "http://test.doubtnut.com/"
    }

    val moviesRepository: MoviesRepository


    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .connectTimeout(20000, TimeUnit.MILLISECONDS)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .writeTimeout(20000, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        val retrofit = Retrofit.Builder() //for BaseURL2
            .baseUrl(BASE_URL2)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        moviesRepository = MoviesRepository(retrofit.create(MovieService::class.java))

    }
}