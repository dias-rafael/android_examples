package com.example.rafaeldias.nybooks.data

import com.example.rafaeldias.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "m9bEOHXfhOUapFbAqOCcwT1WREpxD5hw",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}