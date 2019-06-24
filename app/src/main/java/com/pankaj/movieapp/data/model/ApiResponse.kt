package com.pankaj.movieapp.data.model


data class ApiResponse<T>(val meta: ResponseMeta, val data: T, val error: T?) {

    data class ResponseMeta(val code: Int, val message: String, val  success: String?)
//    data class ResponseError(val Status: String?, val Details: String?)
}