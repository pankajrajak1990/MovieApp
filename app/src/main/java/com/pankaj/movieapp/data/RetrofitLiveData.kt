package com.pankaj.movieapp.data

import androidx.lifecycle.LiveData
import com.pankaj.movieapp.data.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Automatically enqueue retrofit calls when a observer is attached

class RetrofitLiveData<T>(private val call: Call<T>) : LiveData<Outcome<T>>(), Callback<T> {

    override fun onActive() {
        if (!call.isCanceled && !call.isExecuted) {
            postValue(Outcome.loading(true))
            call.enqueue(this)
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        postValue(Outcome.failure(t!!))
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response?.body() is ApiResponse<*>) {
            val apiResponse: ApiResponse<T> = (response as Response<ApiResponse<T>>).body()!!
            when {
                apiResponse.meta.code == 200 -> postValue(Outcome.success((response as Response<T>).body()!!))
                apiResponse.meta.code == 401 -> postValue(Outcome.apiError(Throwable(apiResponse.meta.message)))
                else -> postValue(Outcome.apiError(Throwable(apiResponse.meta.message)))
            }
        } else if (response!!.code() == 401) {
            if (response!!.message() == "Unauthorized") postValue(Outcome.badRequest(response.message().toString()))
        } else if (response!!.code() == 403) {
            postValue(Outcome.apiError(Throwable(response.message().toString())))
        } else postValue(Outcome.success(response?.body()!!))
    }

    fun cancel() = if (!call.isCanceled) call.cancel() else Unit

    fun makeCall() = call.enqueue(this)
}