package com.pankaj.movieapp.data.util

interface ModelMapper<in T, out R> {
    fun map(to: T): R
}