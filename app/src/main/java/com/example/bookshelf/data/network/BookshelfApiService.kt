package com.example.bookshelf.data.network

import com.example.bookshelf.data.model.VolumeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookshelfApiService {
    @GET("volumes")
    suspend fun searchBooks(
        // tells to append q to the URL
        @Query("q") query: String //query parameter, after the ? part
    ): VolumeResponse
}