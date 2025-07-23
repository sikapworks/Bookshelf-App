package com.example.bookshelf.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookshelfApi {
    //points to the root of the Google Books API
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    // lazy initialized, only created when used
    val retrofitService: BookshelfApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookshelfApiService::class.java)  // interface class type
        // .create() creates the implementation of the current interface
    }

    //Api interface connected to Retrofit
}