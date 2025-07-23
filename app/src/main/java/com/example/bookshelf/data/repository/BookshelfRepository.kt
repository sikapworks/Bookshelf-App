package com.example.bookshelf.data.repository

import com.example.bookshelf.data.model.VolumeResponse
import com.example.bookshelf.data.network.BookshelfApiService


// acts as the middle layer between viewmodel and API
class BookshelfRepository(
    private val apiService: BookshelfApiService
) {
    suspend fun getBooks(
        query: String
    ): VolumeResponse {
        return apiService.searchBooks(query)
    }
}