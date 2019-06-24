package com.pankaj.movieapp.data.util

import com.pankaj.movieapp.data.RetrofitLiveData
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 * @param <R>
</R> */
class LiveDataCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, RetrofitLiveData<R>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): RetrofitLiveData<R> {
        return RetrofitLiveData(call)

    }

}