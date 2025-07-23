package com.example.bookshelf.data.model

import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("title")
    val title: String,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks
)