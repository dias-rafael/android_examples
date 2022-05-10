package com.example.rafaeldias.nybooks.data

import retrofit2.Call
import retrofit2.http.GET

interface NYTServices {
    @GET("lists.json")
    fun getBooks(): Call<>
}